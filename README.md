# trabalho-poo-escola

Projeto de Gestão Escolar com Coleções Java

Este repositório contém a solução para o trabalho da disciplina de Programação Orientada a Objetos, focado no uso das coleções List, Set e Map da plataforma Java.

Integrantes
[José Torres de Araujo Neto]
[João Vitor Fernandes de Sousa]
[Luiz Matheus Soares Batista da Cunha]

Descrição do Projeto
O programa simula um sistema de gestão para uma escola de ensino médio, permitindo gerir estudantes, disciplinas e as suas respetivas matrículas com notas. A aplicação carrega um conjunto de dados predefinido e gera relatórios no terminal, como a lista de alunos, a lista de disciplinas, o controlo de duplicatas, as médias individuais e o ranking dos melhores alunos.

Justificativa das Escolhas de Coleções
A seleção das implementações de cada coleção foi baseada nos requisitos de performance e funcionalidade de cada parte do trabalho:

List (Estudantes): Foi utilizado o ArrayList para armazenar os estudantes. Esta escolha deve-se ao acesso rápido por índice (O(1)), que é útil, e ao facto de a maioria das operações de adição ocorrer no final da lista. A ordenação é gerida de forma eficiente através do método sort.

Set (Disciplinas): Foi escolhido o LinkedHashSet para garantir que não existissem disciplinas duplicadas, utilizando o código da disciplina como critério de unicidade. Além disso, o LinkedHashSet cumpre o requisito de manter a ordem original de inserção dos elementos, o que era necessário para a exibição do relatório final.

Map (Matrículas/Notas): A implementação HashMap foi usada para associar o ID de um estudante (Integer) a uma lista das suas matrículas (List Enrollment>). O HashMap oferece a forma mais rápida (O(1) em média) para obter as notas de um aluno a partir do seu ID, tornando as consultas de média e a geração de relatórios muito eficientes.

Como Executar o Programa
Para compilar e executar o projeto, siga estes passos no terminal, a partir da pasta raiz do projeto:

Para compilar todos os ficheiros .java, use o comando:
javac /.java .java

Para executar a classe principal e guardar a saída no ficheiro output.txt, use o comando:
java App > output.txt

Abra o ficheiro output.txt para ver os relatórios gerados pelo programa.

Desafios Encontrados
Um dos principais desafios foi o desenvolvimento de uma lógica eficiente para calcular a média de uma disciplina específica, pois exigia a iteração por toda a estrutura de dados do Map (todos os alunos) para recolher as notas relevantes para apenas uma disciplina. A utilização de Streams do Java simplificou esta tarefa.
