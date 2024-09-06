# Compilando arquivos Java
javac Main.java

if [ $? -ne 0 ]; then
	echo "Erro ao compilar projeto (comando: javac Main.java)\n"
	exit 1
fi

java Main "./resources/exemplos-io/input.txt" "./output/output-1.txt"
java Main "./resources/exemplos-io-dados-invalidos/input.txt" "./output/output-2.txt"
java Main "./resources/exemplos-io-mais-dados/input.txt" "./output/output-3.txt"

diff "./resources/exemplos-io/output.txt" "./output/output-1.txt" > "./output/diff_1.txt"
diff "./resources/exemplos-io-dados-invalidos/output.txt" "./output/output-2.txt" > "./output/diff-2.txt"
diff "./resources/exemplos-io-mais-dados/output.txt" "./output/output-3.txt" > "./output/diff-3.txt"

# Removendo arquivos .class
rm *.class
