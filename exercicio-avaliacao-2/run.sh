#!/bin/bash

# Compilando arquivos Java
cd ./src/main/java
javac Main.java

if [ $? -ne 0 ]; then
	echo "Erro ao compilar projeto (comando: javac Main.java)"
	exit 1
fi

# Define arrays com os caminhos de entrada e saída
example_files_paths=(
	"../resources/io"
	"../resources/io-more-data"
	"../resources/io-invalid-data"
)

output_path="../../output"
# Garantindo que o diretório de saída exista
mkdir -p "$output_path"

# Executa o programa para cada conjunto de entradas/saídas e compara resultados
for i in ${!example_files_paths[@]}; do
	input="${example_files_paths[$i]}/input.txt"
	expected_output="${example_files_paths[$i]}/output.txt"
	actual_output="$output_path/output-$((i+1)).txt"

	# Executa o programa Java
	java Main "$input" "$actual_output"
	if [ $? -ne 0 ]; then
		echo "Erro ao executar Main com $input"
		exit 1
	fi

	# Compara a saída com o esperado
	diff -u --suppress-common-lines "$expected_output" "$actual_output" > "$output_path/diff-$((i+1)).txt"
	if [ $? -eq 0 ]; then
		echo "Nenhuma diferença encontrada entre $expected_output e $actual_output"
	else
		echo "Diferenças encontradas entre $expected_output e $actual_output (veja $output_path/diff-$((i+1)).txt)"
	fi
done

# Removendo arquivos .class
rm *.class
rm ./**/*.class
