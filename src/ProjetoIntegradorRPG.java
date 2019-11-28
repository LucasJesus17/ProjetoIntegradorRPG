
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipe.acanejo
 */
public class ProjetoIntegradorRPG {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_CYAN = "\u001B[36m";

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static String[][] desafios = new String[5][9];
    static int linhaUsuario = 0;
    static int desafiosResolvidos = 0;
    static int ultimaEscolha = -1;
    static int[] ultimoIndice = new int[7];

    static String[] comoJogar = new String[]{
        "Este jogo consiste em perguntas e respostas, onde vc decide a dificuldade dessas perguntas.",
        "",
        "A cada pergunta você tem direito a girar um dado, e dependendo do valor desse dado você podera obter dicas para as respectivas perguntas.",
        "",
        "Não se preocupe em errar!você podera tentar quantas vezes for necessário."

    };

    static String[] enredo = new String[]{
        "Toda história tem um início e a sua começa aqui...",
        "Jornal Senac 10/02/2098 - \"Nova descoberta revolucionária promete rejuvenescer pessoas\"",
        "Jornal Senac 15/06/2098 - \"A descoberta foi um sucesso e recebe o nome de 942z\"",
        "Jornal Senac 06/09/2099 - \"Teste da milagrosa 942z em humanos começa\"",
        "Como um dia qualquer você acorda um dia ensolarado, tudo ocorre normalmente a única ",
        "coisa que te incomoda é esse cheiro incessante de queimado",
        "quando você se aproxima avista ao lado leste da cidade fumaça subindo, quando passa ",
        "carros de polícia e de bombeiros.",
        "Dica do mestre ligue a televisão.",
        "Ligar televisão?",
        "Jornal senac - eles esconderam tudo de nós os testes deram errado fujam para o posto de ajuda.",
        "bom infelizmente a transmissão foi cortada!",
        "Quando você escuta “Saiam Já de suas casas é uma ordem, estamos checando todos os",
        "moradores desta região, então falarei mais uma vez, SAIAM JÀ DE SUAS CASA”.",
        "é um policial com um alto - falante.",
        "Vai sair de casa ?",
        "Chegando na rua o soldado passa uma especie de maquina voce não entendo muito bem",
        "mais parece q eles esta procurando algo. Então ele te libera e continua chamando os outros",
        "moradores da rua. Até que eles chegam em frente a casa de seu melhor amigo. batem e",
        "batem mais parece que ele não está lá. entrando no carro do policial você avista em um tipo",
        "de papel alguns números porém esta incompleto.",
        "você observa que não são apenas números aleatórios mas sim uma fórmula, até que você escuta :",
        "“ parado aí você vamos verificar seu corpo… ei você está me ouvindo?, mais um passo eu atiro !!!”",
        "Quando na frente de seu carro aquela pessoa avança no policial os dois caem ao chão sem ",
        "pensar o soldado que estava no banco do motorista da partida e passa por cima dos dois.",
        "estranhamente  seu amigo está a sua frente, tenta falar com ele mais não parece surtir ",
        "efeito, ele está quieto apenas não te responde, aparentemente não há nada de diferente. ",
        "todos os outros apesar de estarem com medo parecem normais. até que um deles fala :",
        "  - Pessoa : “Ou Policial nos explique oque esta acontecendo… soldado oque esta acontecendo na cidade?”",
        "  - Policial : “Eu não sei muito bem, e o pouco que sei não posso dizer a vcs...”",
        "  - Pessoa : “O que mais como assim não pode nos contar?... tem coisas estranhas por aí atacando pessoas e você não vai nos contar? está me ouvindo?”	",
        "Então esta pessoa começa a puxar o policial pelo ombro",
        "  - Policial: ”Pare de insistir se não lhe mato aqui mesmo...”",
        "  - Pessoa: “Você não pode fazer isso eu sou um cidadão desta cidade você tem que me explicar... ”",
        "sem hesitar o policial saca sua arma se vira e aponta ela para aquela pessoa.",
        "com a tensão do momento o policial acaba perdendo o controle do carro e caindo de uma ribanceira.",
        "Após uns 15 minutos você acorda seu amigo está te puxando para fora do carro, infelizmente",
        "vocês são os únicos sobreviventes,e estão no meio da floresta perdidos, quando você se",
        "lembre dentro do carro havia alguns papéis, um deles é um mapa da área e o outro a fórmula ",
        "estranha que você viu quando entrou no carro.",
        "Bom você sabe exatamente onde estão seguindo a oeste chegam lá sem o menor problema.",
        "Ao cair da noite vocês chegam contam aos guardas o que houve e conseguem passar.",
        "Em meio a noite o seu amigo começa a se debater e contorcer na cama…",
        "Os médicos entram lhe dão um sedativo e você apaga novamente,antes de estar totalmente sedado você escuta você deu a dóse na pessoa errada era no infectado.",
        "Então você acorda a muitos corpos no chão parece que houve uma guerra ou algo assim, ",
        "saindo do quarto você encontra seu melhor amigo, sem pensar você pergunta :",
        "  - Você : “ Oque aconteceu?... porque te levaram?”",
        "  - Amigo : “eu não sei, eles apenas me levaram injetaram algo em mim ...”",
        "De repente você escuta batidas na porta atrás de vocês, rapidamente o seu amigo lhe puxa ",
        "para dentro de uma das salas daquele corredor, Diferente daquela que você passou a noite esta sala parece uma de pesquisas.",
        "  - Amigo: “OU..OU...OU...ESTÁ OLHANDO PARA ONDE, eu arrasto as coisas você faz a fórmula.",
        "explicando rapidamente você já viu uma parte da fórmula agora termine o resto eu seguro a porta”",
        "  - Amigo: “Na segunda gaveta está o passo a passo da fórmula final”",
        "Analisando o passo a passo tem coisas como:",
        "Conversão de decimal para binário.",
        "porta lógica.",
        "mintermo/maxtermo.",
        "algebra de boole.",
        "mapa karnaugh",
        "  - Amigo: “Você não faz a mínima ideia de como faz né? eu vou dar uma explicação rápida sobre tudo que está aí”",
        "  - Amigo: ”Conversão de decimal para binário.",
        "Para realizar a conversão de decimal para binário, realiza-se a divisão sucessiva por 2.”",
        "  - Amigo: ”porta lógica\"existem diversa portas lógicas porém as 3 bases são:",
        "NOT : a’  sempre inversa do valor base",
        "OR : a+b uma das variáveis tem que dar 1",
        "AND : a*b para dar 1 as duas variáveis tem que ser 1”",
        "  - Amigo: ”mintermo/maxtermo.",
        "mintermo :”multiplica as variáveis”",
        "maxtermo :”soma as variáveis”",
        "  - Amigo: “algebra de boole.",
        "“NOT : Sempre inversa do valor base”",
        "“OR : Uma das variáveis tem que dar 1”",
        "“AND : Para dar 1 as duas variáveis tem que ser 1”",
        "  - Amigo: “Mapa de karnaugh",
        "“Unir o máximo de 1 possíveis”",
        "“sendo possível unir : 1,2,4,8,16”",
        " - Amigo : “Anda logo eu não vou conseguir segurar por muito tempo… Rápido!!! ”",
        "As batidas parece que aumentaram quando seu amigo cai…",
        "Você escuta batidas em sua porta. Eles arrombam ela instantaneamente partem para cima",
        "te agarram e te levam pra prisão. entrando no carro do policial você avista em um tipo de",
        "tablet alguns números porém esta incompleto.",
        "Mais ao fundo você escuta.",
        "- você é bem curioso. Bom sabe eu me chamo ",
        "- Jschirtt sou um dos cientistas que criou isso que eles chamam de infecção, são uns tolos o",
        "mundo já estava infectado nós apenas criamos a cura a doença na verdade é a raça hum...",
        "bom estamos sendo levados para a cadeia é bom eu levar este papel pode ser útil.",
        "Ele pega o papel e coloca no bolso, chegando lá você é jogado em uma cela como se fosse",
        "um animal existem mais algumas pessoas aí inclusive o Jschirtt. Da para ver que ninguém",
        "estava normal alguns com braços meio roxos e  outros nas pernas.",
        "- Jschirtt - Logo todos nós ficaremos assim. Bom eu tenho um plano eu sei como me livrar",
        "de minha criação porém eu estou com a perna ferida",
        "Finalmente você vê uma das pernas de Jschritt está estranha até parece que está morta.",
        "Quando se aproxima da cela ao lado dali está vindo uns barulhos estranhos algo avança na",
        "sua direção batendo de frente com as barras da cela, o susto te lança para trás o fazendo",
        "cair do outro lado. Você sente algo estranho uma dor olhando pro lado um cara mordeu seu",
        "braço ele grita parecendo que queria te intimidar. Quando um guarda chega e dá um tiro",
        "nele sem nem se importar com outros ao redor.",
        "- Guarda 1 - Meus deus o que será disso essas coisas estão cada vez mais fora do",
        "controle. Nos primeiros testes eles não ficava assim agora.",
        "- Guarda 2 - Realmente eu queria ainda bem que daqui a pouco vamos embora.",
        "- Guarda 1 - Espera aquele não é o Jshcirtt ?... que pena foi descuidado e infectado.",
        "Ele era um dos melhores.",
        "- Guarda 2 - Coisas assim acontecem infelizmente...",
        "Essa sensação de perigo esta incessante, porém a dor no seu braço é maior, parece esta",
        "queimando a dor é tão intensa que você desmaia.",
        "- Jschirtt - Ei...Ei...Acorda os guardas já se foram",
        "Você acorda o seu braço ainda dói e ele está muito estranho parece que está mais lento.",
        "- Jschirtt -Essas portas são bem fáceis de abrir. Já estive aqui algumas vezes você",
        "precisará de conhecimento lógico para passar pelos lugares digite os seguintes números",
        "942z que a habilitaram a possibilidade de você resolver uma pergunta para acesso.",
        "- Jschritt -Provavelmente eles não mudaram os desafio então lhe direi como resolvê-los",
        "- Jschritt -Você não faz a mínima ideia de como faz né? eu vou dar uma explicação rápida",
        "sobre tudo que está aí",
        "- Jschritt -Conversão de decimal para binário.",
        "Para realizar a conversão de decimal para binário, realiza-se a divisão sucessiva por 2.",
        "- Jschritt - porta lógica",
        "existem diversa portas lógicas porém as 3 bases são:",
        "NOT : a’  sempre inversa do valor base",
        "OR : a+b uma das variáveis tem que dar 1",
        "AND : a*b para dar 1 as duas variáveis tem que ser 1",
        "- Jschirtt -mintermo/maxtermo.",
        "mintermo :multiplica as variáveis",
        "maxtermo :soma as variáveis",
        "- Jschirtt -álgebra de boole.",
        "NOT : Sempre inversa do valor base",
        "OR : Uma das variáveis tem que dar 1",
        "AND : Para dar 1 as duas variáveis tem que ser 1",
        "- Jschirtt - Mapa de karnaugh",
        "Unir o máximo de 1 possíveis",
        "sendo possível unir : 1,2,4,8,16",
        "- Jschritt -Este é o mapa daqui va até os cantos desta prisão e use este conhecimentos para",
        "passar pelas dificuldades... Ah sim claro os itens são uma seringa com C2H5OH...acho que",
        "você nem vai notar a diferença então vou diferenciar por cor, a seringa tem um liquido",
        "parecido com águas, Um frasco com um líquido verde, uma bolsa de sangue e um balde.",
        "Ele lhe entrega um mapa com marcações de onde está cada coisa. Seu primeiro desafio",
        "será abrir esta cela.",
        "Você digita 942z e surge uma pergunta:",
        "Você conseguiu mas não pense que todos os desafio serão fáceis como este,e agora tem a",
        "senha de todas as portas. Esta é a última cela seguindo a direita dá pra se escutar muitos",
        "gritos alguns de dor outros estranhos. Porém algo que lhe chama atenção é ums choro",
        "vindo mais a frente, após 5 passos da para ver que aqui é uma sala diferente porém",
        "vindo mais a frente, após 5 passos da para ver que aqui é uma sala diferente porém",
        "voce não podera entrar. Seguindo a frente existe uma outra porta você adentra a sala sem",
        "problema algum, aqui está marcado no mapa vasculhando um pouco pela sala tem um vidro",
        "parece exatamente com o que ele lhe pediu um líquido verde dentro de um frasco.",
        "com sua procura você além de conseguir abrir o vidro você acaba encontrando um lanterna",
        "com uma chave pendurada nela esta chave tem um símbolo que lhe é familiar.",
        "O próximo item está embaixo de você ao seu lado esquerdo existe algo como se fosse um alçapão",
        "abrindo-o parece ter um sótão o problema é que está escuro demais porém você pega a",
        "lanterna e desce, a cena é estranha parece que a sala está toda destruída o cheiro de carne",
        "podre é incessante, a único coisa visível é a frente de sua lanterna e agora dá pra ver que a",
        "sala é um pouco maior do que parecia. Logo avista uma bolsa de sangue pendurada como",
        "se fosse em um hospital aproximando-se dela você escuta um barulho parece que algo caiu",
        "na sala, olhando a sala algo passa em frente a sua lanterna muito rápido, vira pra direito",
        "para esquerda e nada parece até mesmo uma alucinação até que ...",
        "Um barulho vem do teto, é um homen de capuz? Ele salta em sua direção e como se fosse",
        "por um instinto você se dá um passo pra segurar o ferro da bolsa de sangue, meio que pro",
        "alto e o bixo se empala o ferro atravessa o pescoço. logo vem uma tremedeira você?matou",
        "alguém?... bom não é hora de hesitar era ele ou você. Finalmente você consegue  retirar a",
        "bolsa de sangue e encontrar a seringa, subindo de volta. A sua frente tem uma câmera de",
        "segurança eles não podem ver que você esteve aqui, dá até para utilizar o código que o",
        "jschirtt te deu porém existe mais uma pergunta.",
        "Você consegue apagar as fitas de segurança porém o que aconteceu lá embaixo não a",
        "oque fazer. Em meio ao caminho ao Jschitt veio a sua memória ainda falta um item o balde.",
        "Aqui está um pouco mais escuro do que antes parece que este local está prestes a ser",
        "largado. Logo você está do lado daquela porta outra vez, porém desta vez ao olha pra ela",
        "logo vem a sua mente é o mesmo símbolo que está na chave, sem pensar muito você",
        "remove a chave da lanterna e coloca na porta, e agora entrar na sala ou voltar sem um item?",
        "Não entrar na sala",
        "Deseja entrar na sala?"
    };

    //{ NÚMERO ÍNDICE ENREDO, EXIBIR DESAFIO, DADO DO USUÁRIO >= 15 EXIBIR HISTÓRIA }
    //0 - NÃO 1 - SIM
    static int[][] indiceEnredo = new int[][]{
        { 8, 0, 1 },
        { 9, 0, 0, 10, 11, 12, 12 },
        { 15, 0, 0, 16, 77, 78, 167  },
        { 21, 1, 0 },
        { 39, 1, 0 },
        { 75, 1, 0 },
        { 76, 1, 0 },
        { 77, 1, 0 },
        { 80, 1, 0 },
        { 136, 1, 0 },
        { 144, 1, 0 },
        { 154, 1, 0 },
        { 162, 1, 0 },
        { 168, 0, 1 },
        { 169, 0, 0,  },
    };

    static String[] creditos = new String[]{
        "==================",
        "     CRÉDITOS     ",
        "==================",
        "Esse foi o nosso jogo, esperamos que tenham gostado e obrigado por jogar. :)",
        "     FEITO POR:   ",
        "-------------------",
        "Grupo 9 - TADS Turma A",
        "Felipe Canejo",
        "Jardel Junior",
        "Lucas De Jesus",
        "Lucas Santiago"
    };

    static String[][] facil = new String[][]{
        {"O número 1001 1001 0111‬ em sistema de base 2, seria representado por qual opção abaixo:", "2455", "998", "1000", "45E", "a", "A alternativa possui dois valores ímpares", "Utilize a calculadora do Windows como programador", "A alternativa possui dois valores pares"},
        {"Os computadores utilizam o sistema binário que é um sistema de numeração em que todas as quantidades \nse representam com base em dois números, ou seja, (0 e 1). \nEm um computador o número 2012, em base decimal, será representado, em base binária, por:", "110111", "11111011100", "111110111000", "111110111", "b", "A alternativa correta tem números 0", "A alternativa correta possui o valor de números semelhante a alternativa C -1", "Utilize a calculadora do Windows como programador"},
        {"Este o enigma (C=A.B) corresponde a qual porta lógica?", "Porta NAND", "Porta NOT", "Porta AND", "Porta OR", "c", "A alternativa correta é a letra E em inglês", "A alternativa correta possui somente 3 caracteres", "Uma comparação"},
        {"Abaixo apresentamos quatro números em suas representações binárias. \n\n1) 0101001\n2) 1101001\n3) 0001101\n4) 1010110\n\nAssinale a alternativa que apresenta o somatório dos 4 números acima convertidos para o formato decimal.", "245", "101", "111", "267", "a", "A altermativa correta possui valor maior que 105", "A alternativa correta possui valor maior que 200", "A alternativa correta possui dois numeros pares"},};

    static String[][] medio = new String[][]{
        {"Para atravessar um lago(L), deve ser usado a seguinte expressão lógica L = !P, \nonde P são as pessoas, podemos deduzir que:", "As pessoas que querem atravessar tem como valor 0", "As pessoas que querem atravessar tem como valor 1", "O lago funciona como a porta lógica inversora", "Alternativas a e c estão corretas", "d", "A alternativa correta é usada como referências para as respostas certas", "O lago inverte", "As Pessoas recebem valor 0"},
        {"Portas ou circuitos lógicos são dispositivos que operam um ou mais sinais lógicos \nde entrada para produzir uma e somente uma saída, dependente da função implementada no circuito. \nSão geralmente usadas em circuitos eletrônicos, por causa das situações que os sinais\ndeste tipo de circuito podem apresentar:presença de sinal, ou “1”; e ausência de sinal, ou “0”.\nPara a tabela verdade apresentada a seguir, é correto afirmar que, em ordem, as portas lógicas são: ", "NAND; NOR; AND; OR", "NAND; NOR; OR; AND", "AND; NOR; NAND; OR", "NAND; OR; AND; NOR", "c", "A alternativa correta começa com uma porta E", "A alternativa correta termina com uma porta OU", "Unica alternativa que nao comeca com uma porta inversora"},
        {"Um multiplexador digital proporciona uma maneira de selecionar uma das entradas para ser ligada a uma única saída. Sobre a implementação de tais dispositivos, considere as seguintes afirmativas:\n" +
            "1. Um multiplexador com 16 entradas necessita de 16 bits de seleção.\n" +
            "2. Um multiplexador pode ser implementado em dois estágios: o primeiro consiste em portas inversoras e portas AND entre os bits de seleção e o segundo em uma porta OR entre as saídas do primeiro estágio.\n" +
            "3. Um multiplexador pode ser implementado utilizando-se um conjunto de flip-flops conectados entre si através de portas AND, utilizando como sincronismo os bits de seleção.\n" +
            "4. Um multiplexador digital pode ser utilizado para gerar uma função lógica arbitrária das variáveis selecionadoras.\n" +
            "Assinale a alternativa correta.", "Somente as afirmativas 1 e 4 são verdadeiras.", "Somente as afirmativas 2 e 3 são verdadeiras", "Somente as afirmativas 2 e 4 são verdadeiras.", "Somente as afirmativas 1, 3 e 4 são verdadeiras.", "c", "Não é a alternatica b", "x + y = 6", "Alternativas pares corretas"},};

    static String[][] dificil = new String[][]{
        {"Mapa de Karnaugh é um método de simplificação gráfico criado por Edward Veitch e aperfeiçoado pelo engenheiro de telecomunicações Maurice Karnaugh. Chamamos esse diagrama de mapa, visto este ser um mapeamento biunívoco a partir de uma tabela verdade da função que está a ser analisada.\n" +
"Em que ano foi criado o mapa de Karnaugh?", "1880", "1876", "1952", "1980", "c", "MCMLII", "A partir de 1900", "Década de 50"},
        {"Em que é utilizado o Mapa de karnaugh?", "Para simplificar uma equação lógica", "Para calcular a temperatura do oceano", "Para converter uma tabela verdade", "Simplificar uma equação lógica e converte uma tabela verdade no seu circuito lógico correspondente", "d", "O mapa é utilizado na simplificação", "Várias funcionalidades", "Circuito"},
        {"O método de leitura por \"mapa de Karnaugh\" é considerado mais simples que a \"álgebra booleana\", pois elimina o problema de erro nas simplificações. Porém quando utilizado mais de N entradas, esse método se torna complicado, pois fica difícil identificar as células adjacentes no mapa. Para esse caso são utilizados soluções algorítmicas computacionais \n" +
"Nos valores abaixo qual representa o valor de N entradas acima?", "3", "15", "5", "6", "d", "Raiz quadrada de 36", "2,5*2,4", "Utilize o Google"},};

    static int[] retornarIndiceEnrredo() {
        int[] indice = new int[3];

        for (int i = 0; i < indiceEnredo.length; i++) {
            if (indiceEnredo[i][0] == linhaUsuario) {
                indice = indiceEnredo[i];
            }
        }
        return indice;
    }

    static boolean indiceExibirDesafio() {
        boolean exibir = false;
        int[] indice = retornarIndiceEnrredo();

        if (indice[0] > 0) {
            exibir = indice[1] == 1;
        }

        return exibir;
    }

    static boolean indiceDado() {
        int desejoUsuario;
        boolean exibir = true;
        int[] indice = retornarIndiceEnrredo();

        if (indice[0] > 0) {
            if (indice[2] == 1) {
                System.out.printf("\nVocê pode ter uma dica do mestre, deseja jogar o dado? \n");
                desejoUsuario = escolha();
                if (desejoUsuario == 1) {
                    int dado = jogarDado1a20();
                    exibir = dado >= 15;
                    if (!exibir) {
                        System.out.printf("Valor insuficiente, tente na próxima.\n");
                    }
                    aguardar(1);
                } else {
                    exibir = false;
                }
            }
        }

        return exibir;
    }

    static void novoJogo() {
        linhaUsuario = 0;
        desafiosResolvidos = 0;
        limparEscolha();

        //Escolha da dificuldade e escolha dos desafios
        dificuldadeJogo();
        System.out.println("");
        do {
            int[] indice = retornarIndiceEnrredo();
            boolean linhaEscolhaUsuario = indice[0] > 0 && indice.length > 3;
            if (linhaEscolhaUsuario) {
                System.out.println("");
            }
            boolean exibirEnredo = indiceDado();
            if (exibirEnredo) {
                System.out.println(enredo[linhaUsuario]);
            }

            if (linhaEscolhaUsuario) {
                //Salvando info do indice para verificar onde trecho da escolha termina
                ultimoIndice = indice;
                ultimaEscolha = escolha();
                System.out.println("");
                if (ultimaEscolha == 1) { //Sim
                    linhaUsuario = indice[3];
                } else if (ultimaEscolha == 2) { //Não
                    linhaUsuario = indice[5];
                }
            } else {
                //Espera 3 segundos para continuar
                if (exibirEnredo) {
                    aguardar(3);
                }

                if (indiceExibirDesafio()) {
                    exibirDesafio();
                }

                if (ultimaEscolha == 1 && linhaUsuario == ultimoIndice[4]) {
                    linhaUsuario = ultimoIndice[6] + 1;
                    limparEscolha();
                } else if (ultimaEscolha == 1 && linhaUsuario == ultimoIndice[6]) {
                    limparEscolha();
                    linhaUsuario++;
                } else {
                    linhaUsuario++;
                }
            }
        } while (linhaUsuario < enredo.length);
        System.out.println("Fim");

        creditos(true);
    }

    static void limparEscolha() {
        ultimaEscolha = -1;
        ultimoIndice = new int[7];
    }

    static void exibirDesafio() {
        //TODO Controle de 3 dicas para o usuário

        //Verificando se ainda existe desafios a serem resolvidos
        if (desafiosResolvidos < desafios.length) {
            boolean acertou = false;
            //Recuperando próximo desafio
            String[] proximoDesafio = desafios[desafiosResolvidos];
            //Retornando resposta correta do desafio
            String respostaCorreta = proximoDesafio[5];
            String respostaUsuario;
            char[] opcoes = new char[]{'a', 'b', 'c', 'd'};

            //Separando as dicas em uma variável separada
            String[] dicas = new String[3];
            int indexDica = 0, desejoUsuario = 0, dicasExibidas = 0;
            //Começa do 6 pois na matrix dos desafios as dias estão a partir do indice 6
            for (int i = 6; i < proximoDesafio.length; i++) {
                dicas[indexDica] = proximoDesafio[i];
                indexDica++;
            }

            do {
                //Exibindo enunciado do desafio

                System.out.printf("\n%sDESAFIO %d%s\n", ANSI_CYAN, desafiosResolvidos + 1, ANSI_RESET);
                System.out.printf("\n%s\n", proximoDesafio[0]);

                //Exibindo alternativas
                for (int i = 1; i < 5; i++) {
                    System.out.println(opcoes[i - 1] + ") " + proximoDesafio[i]);
                }
                if (dicasExibidas < dicas.length) {
                    System.out.printf("\nO que deseja fazer? \n<1> Rolar o dado para uma dica \n<2> Reponder desafio \n");
                    desejoUsuario = input.nextInt();
                    if (desejoUsuario == 1) {
                        int dado = jogarDado1a20();
                        if (dado == 20) {
                            System.out.println("Como você tirou 20 você tem o direito de ver todas as dicas:");
                            for (int i = 0; i < dicas.length; i++) {
                                System.out.println("Dica " + (i + 1) + "/" + dicas.length + " - " + dicas[i]);
                            }
                            dicasExibidas = dicas.length + 1;
                        } else if (dado == 1) {
                            System.out.println("Como você tirou 1 você perdeu todas as dicas.");
                            dicasExibidas = dicas.length + 1;
                        } else if (dado >= 15) {
                            System.out.println("Dica " + (dicasExibidas + 1) + "/" + dicas.length + " - " + dicas[dicasExibidas]);
                            dicasExibidas++;
                        } else {
                            System.out.printf("Valor insuficiente, tente na próxima.\n\n");
                        }
                    }
                } else {
                    System.out.println("Acabou suas dicas!");
                }
                System.out.print("Resposta: ");
                respostaUsuario = input.next();
                acertou = respostaUsuario.equalsIgnoreCase(respostaCorreta);
                if (!acertou) {
                    System.out.println(ANSI_RED + "Reposta incorreta." + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "Certa resposta." + ANSI_RESET);
                }
                aguardar(1);

            } while (!acertou);

            desafiosResolvidos++;
        }
    }

    static void exibirMenu() {
        int opcaoMenu = 0;

        do {
            System.out.println("<1> Novo jogo");
            System.out.println("<2> Como jogar");
            System.out.println("<3> Créditos");
            System.out.println("<4> Sair");
            System.out.print("Digite uma opção para continuar: ");
            opcaoMenu = input.nextInt();
        } while (opcaoMenu <= 0 || opcaoMenu > 4);

        selecionarMenu(opcaoMenu);
    }

    static void aguardar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
        }
    }

    static void comoJogar() {
        exibirTexto(comoJogar, false);
    }

    static void creditos(boolean fimJogo) {
        exibirTexto(creditos, fimJogo);
    }

    static void exibirTexto(String[] texto, boolean interruptor) {
        for (int i = 0; i < texto.length; i++) {
            System.out.println(texto[i]);

            if (interruptor) {
                //Espera 2 segundos para exibir o próximo trecho dos créditos
                aguardar(1);
            }
        }
        System.out.println("Aperte qualquer tecla para voltar...");
        input.next();
        exibirMenu();
    }

    static void selecionarMenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                novoJogo();
                break;
            case 2:
                comoJogar();
                break;
            case 3:
                creditos(false);
                break;
        }
    }

    static int escolha() {
        int opcao = 0;
        do {
            System.out.println("<S> Sim");
            System.out.println("<N> Não");
            char escolhaDoUsuario = input.next().toLowerCase().charAt(0);

            switch (escolhaDoUsuario) {

                case 's':
                    opcao = 1;
                    break;
                case 'n':
                    opcao = 2;
                    break;

            }
        } while (opcao == 0);
        return opcao;
    }

    static int jogarDado1a20() {
        int dado = 1 + random.nextInt(20);
        System.out.printf("\nVocê tirou %s%d%s no dado\n", ANSI_CYAN, dado, ANSI_RESET);

        return dado;
    }

    static void dificuldadeJogo() {
        System.out.println("\nEscolha um nível de dificuldade: \n<1> Fácil\n<2> Médio\n<3> Dificil");
        int escolhaUser = input.nextInt();
        switch (escolhaUser) {
            case 1: //Fácil

                desafios = embaralhar(facil);
                desafios[desafios.length - 1] = retornarItemAleatorio(medio);

                break;
            case 2: //Médio
                desafios[0] = retornarItemAleatorio(facil);

                String[][] medioEmbaralhado = embaralhar(medio);

                for (int i = 0; i < medioEmbaralhado.length; i++) {
                    desafios[i + 1] = medioEmbaralhado[i];
                }

                desafios[desafios.length - 1] = retornarItemAleatorio(dificil);
                break;
            case 3: //Difícil                
                desafios[0] = retornarItemAleatorio(facil);
                desafios[1] = retornarItemAleatorio(medio);

                String[][] dificilEmbaralhado = embaralhar(dificil);

                for (int i = 0; i < dificilEmbaralhado.length; i++) {
                    desafios[i + 2] = dificilEmbaralhado[i];
                }
                break;
        }
    }

    static String[] retornarItemAleatorio(String[][] desafios) {
        int indiceAleatorio = random.nextInt(desafios.length) + 1;
        return desafios[indiceAleatorio - 1];
    }

    static String[][] embaralhar(String[][] matriz) {
        Collections.shuffle(Arrays.asList(matriz));
        return matriz;
    }

    public static void main(String[] args) {
        exibirMenu();
    }
}
