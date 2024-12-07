# Template Java API Test
Template de testes de API em Java utilizando [JUnit4](https://junit.org/junit4/) e [RestAssured](https://rest-assured.io/).

## Pré-requisitos
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) deve estar instalado.
- [Apache Maven](https://maven.apache.org/download.cgi) deve estar instalado.

## Instalação
Para instalar as dependências do projeto, execute o seguinte comando:

```sh
mvn install
```

## Execução e Relatório de Testes
Para executar os testes, execute o seguinte comando:

```sh
mvn test
```

## Relatório de Testes
O relatório de testes é gerado no caminho <span style="color:green">target/custom-reports/surefire.html</span>

## Plugins
Os seguintes plugins são usados no projeto e estão configurados no arquivo pom.xml:

- [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/): Utilizado para executar os testes unitários.</br>
- [maven-surefire-report-plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/): Utilizado para gerar relatórios de testes em HTML.