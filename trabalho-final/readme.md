# ACME Air Drones

O relatório do projeto e o diagrama de classes da aplicação encontram-se no diretório [docs/](./docs/).

## Execução

É possível executar o projeto a partir de qualquer IDE com suporte à linguagem Java, ou utilizando Maven diretamente da linha de comando, e.g.:

- `mvn clean`: limpa o diretório _target_;
- `mvn compile`: compila a aplicação no diretório _target_;
- `mvn package`: empacota a aplicação em formato _.jar_ no diretório _target_;
- `mvn exec:java`: executa a aplicação (deve ser executado após a compilação).

Lembrando que é possível utilizar vários _goals_ em sequência, e.g. `mvn clean compile exec:java` irá limpar o diretório _target_, compilar a aplicação e executá-la.

