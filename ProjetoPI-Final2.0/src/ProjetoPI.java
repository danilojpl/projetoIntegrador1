/* Projeto Integrador TADS 1ºA
    Criação de um Game RPG Textual
    Integrantes Grupo 11
    Alex Sander
    Danilo Duarte
    Juan Gustavo
*/

// Espaço destilado a importacão de bibliotecas
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjetoPI {
// Declarar Variaveis Global
static String CSI = "\u001B["; // variavel para mudar texto de cor
static String [] personagens = new String [4];
static Random gerador = new Random();
static Scanner entrada = new Scanner(System.in);
static String nome;
static char teste='0';

// Arrays para "Imagens"
static int[] nave = new int[3];
static String[] imagens = new String[3];

// Declarar Funções
// VALIDADOR DE RESPOSTAS
    static char validador (char x){
     //Função para entrada de comando correto!** 
        do{                                                                                     
            x = entrada.next().charAt(0);
        }
       while(x!='1' && x!='2' && x!='3');
     
    return x;
    } 
    
    static void pausa(int segundos){
        segundos = segundos*1000;
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

//Amazenamento das ASCII usadas    
     static void imagens() {
       imagens[0]=" \n" +
"||                       :so/`                `/+`            .s.           -`       `.            :+`                        `-/+/.                    ||\n" +
"||                          -++/-`               --`           `+`           `       .            :-                      `:os+-                 -+.    ||\n" +
"||                              .//:.              `             :                              `:`                    `:++-                     .-     ||\n" +
"||                                  .-.-`                         -                            .-                   .://.                               ||\n" +
"||                                      `...                                                  .`                 .--.                   .-/:            ||\n" +
"||                                          ``                                               `                ...`                 .:/+++-              ||\n" +
"||   .`                                                                          `o                         ``               ``...:-.                   ||\n" +
"||   :/+++/::.`                                                                  +/                                                                     ||\n" +
"||            .--...`                  `                             //`         /                                                                      ||\n" +
"||                                     -/+o+:-`             `         /s`       `            -s                                                      ```||\n" +
"||                                          `.:-...`       `/s+-        -` `+.o`      -`                                               `.-/+oosysoosoo+-||\n" +
"||                                                             .-.          `hNs          ./oo+                             `..-:/++oss+/::-...``       ||\n" +
"||                  ..                                         `         :+yoNNm+s+.  `..::`                         `.....--.`                         ||\n" +
"||             `.------.``                                    ./      .smNNm/NNNyNNNd/                                                                  ||\n" +
"||              `....::://:://::-.....```                            //dNNh./NNNhmNNNNd.               .s.                                              ||\n" +
"||                                                                  s.-NNs` oNNNhdNNNNNN-               `                                               ||\n" +
"||                                                                 s. hNh`  yNNNdmmNNNNNm.                                           ..``...-........```||\n" +
"||                                                                :/ .NN`   dNNNNNdNNNNNNs                                                    ``.----/++||\n" +
"||                                     `.-...``             `.-::-s `sNNmmmNNNNNNNmNNNNNNN:++/:-.`                                                      ||\n" +
"||                              `:+++//:.       `.-:/++++///-.  `h/oNNNNNNNNNNNNNNNNNNNNNNhNNNNNNNNmmdhyo+/:-.` -                        `.             ||\n" +
"||                 -s.        ./:..   `.:/+syhdmNNNNy.          +NNNNmddddNdNNNNmmdddddmNNNNNNNNNNNNNNNNNNNNNNNNdhyo/-                    `             ||\n" +
"||                  `              `/hNNNNNNNmmNNNmmyyyyyyysyyyymNNNNNhsoosdmNmNNdsooshNNNNNNNNmNNNNNNNNNmNmNmNNNNNNNNNs-                               ||\n" +
"||                               .omNmNNNNmNNNNNNNNNNNNNNNNNNNNNms.Ns`.+oo:`-hoh.`:oo/`.hd`hmNNNNmNNNNNNNmNNNNmNNNNNNNNmNd/`                            ||\n" +
"||                               `...`...`..................-/-.`. s`o/hmms//+N://smmh:+-+ ``.................-///:....`...`                 .`         ||\n" +
"||                                                        -+-      .+o+:so:s/o.o/o:+o:+oo`                        .::/:`                      `.-----.` ||\n" +
"||                ``                    ``              -o/          :s/::+o- : -o/::/s-..                            .////-`                       `-+o||\n" +
"||           .--..`                  ...              `o/`            .y:/s   :   s/:s`  y`                                -+oo:.                       ||\n" +
"||    `-///:-`                    .-.                 .`        `.     /sy.   /   .so/   -y`               `..`                -+so:`                   ||\n" +
"||/+o+/-`                     `::-                             :-      -so`   /    oo-    /+                  .::                  .:+//-`              ||\n" +
"||-`                       `/+/`                             `s.       `:.    +    `-`                          .++/`                  `:sh`            ||\n" +
"||                      `:o/`                               -d-              `s                                    :s+:.                                ||\n" ;
       
       
       imagens[1]="\n"
                + "                                                                 ```                                                                                  \n" +
"                                                      ``.-::/+ossydd.                                                                                 \n" +
"                                           ``..-:/+ossssyyso+:-.:s:ds                                                                                 \n" +
"                                ``..-:/+osssssso+/:-:+yddmmmd/ /o` /N-                                                                                \n" +
"                         `-:/+ossssso+/:--.``       yNNNNmdy/-o/   `hy                         `.-:-.                                                 \n" +
"                        -yy+/--.``                  `---..` :o-     :N:                  `.-/osyso+sys+:.                                             \n" +
"                      `/d+`           `.-/+++/`           `++`       yh            `.-/osyso/:.`    `./oyso:.`                                        \n" +
"                     .yh-           .sdNMMMNmy.          .s:         -N:     `.:/osyso/:.`               .:oyyo:.`                                    \n" +
"                    /do`            .osss+/-`           :o.           yd    .hddo:.`  /oo+:.`                .:oyyo/.`                                \n" +
"                  `sd:                                `o+             -N/  `yh`.:/+/.`omMMMNds-         ``       `:+yyo/.`                            \n" +
"                 :hs` .:+syhhy+            ````.-:/+//y/               sd` om.     .:/++shmNNMNs       /ddhs+-`      `-+yys/.`                        \n" +
"               `od/ .yNMMMMNNh/ ```..-://+////::-.`   -y               .N+:m:    ```   .:/+o+/:.       `+dNMMMmo.       `./oyhs+-`                    \n" +
"              -hy.  `+syssso+++////::-.`      ```      s:               ommo   -sdmdy/     `:/+/-`        .:oyhho       yNNNdysoyhy+-`                \n" +
"             +ms:/+/+////:-.`               -sdmdh/`   .y       .yds.   .Nh`  +MMMMMMMs        `:/++-`                  `+dNMMMNy`./shyo-             \n" +
"            `mh-.`                         /MMMMMMMh    s:      yMMMm-  om.   hMMMMMMMN`           `-/++-`                 `:+oss.`-/+smm`            \n" +
"             +m.     -oyhy+`               yMMMMMMMM`   .h      yMMMMh :N:    -mMMMMMN+                `-/++:`              `-/++//-` /N-             \n" +
"             `ms    sMMMMMMN-              .dMMMMMN+     s:     -MMMMN.m+      `:oss/`                      -/++:`     ./+++/-`      .m+              \n" +
"              /N.  `MMMMMMMMy                :oso/`      `h      :mMMsdy                             .+sso:     ./+s++/:`           `hy               \n" +
"              `ds   yMMMMMMN-                             o:       -.sm`  `odNNms-                  sMMMMMMd.     /o                sd`               \n" +
"               /N.   -shhy+`                   `/yddy/    `h        /m-  `dMMMMMMN:                -MMMMMMMMs    -y                /m-                \n" +
"               `dy                            .mMMMMMMd`   o/      -m+   -MMMMMMMMo                `dMMMMMMN:   `y`               -m+                 \n" +
"                /N-     `/oss/`               /MMMMMMMM:   `h`    `ds     oNMMMMMh`                 `/ydmho.    y-               `dy                  \n" +
"                `dy    :mMMMMMN/              `dMMMMMMh`    o/    yd`      ./oo+-                              ++                sd`                  \n" +
"                 :N-   dMMMMMMMm               `:syys:`     `h`  +m.    `.`                     `/syyo-       :s      `+ys.     /N-                   \n" +
"                  hy   +MMMMMMMs                             +/ :N/  `omNNNd+`                 -mMMMMMNs     .y`     :mMMMy    -m/                    \n" +
"                  :N-   :sdmdy:                    :oss+-    `h-ds   hMMMMMMMs                 yMMMMMMMM.   `y.     -NMMMMo   `ds                     \n" +
"                   hy     ```                    `hNMMMMNy    +mh`   dMMMMMMMh                 :NMMMMMMy    o/      sMMMMh`   yd`                     \n" +
"                   :N:     `-/+/-                +MMMMMMMM-   om.    -hMMMMNh.                  .ohdhs:`   /o       /NMmo`   +m-                      \n" +
"                    hh    -dNMMMNh-              -mMMMMMMd`   +hho:.  `.//:.`                      `      -y`        ..`    -m/                       \n" +
"                    :N:   dMMMMMMMh               .ohddh+`     `d+mhyo:.                   .+hddy+`      `y.               `ds                        \n" +
"                     yh   yMMMMMMMs                  ``   `..-:/hds..:+yyo/.`             .mMMMMMMd`     s:                yh`                        \n" +
"                     -N:  `odmNmd+`            ``.-:/+osssssoo+/-.      .-+sys/-`         /MMMMMMMM:    ++                +m.                         \n" +
"                      yh    `...`    `..-:/+ossssso+/:-..``                 `-+sys/-`     `hMMMMMMy`   -s                :m/                          \n" +
"                      -N: ``.-:/+oossssso+/:-.``                                `-+sys+-`  `:oyyo:`   .y`            `.-/do                           \n" +
"                       sdssssoo/:-..``                                              `-/sys+-.        `s-       `.-/osyso/-`                           \n" +
"                       `..`                                                             `-/sys+:.    o/  `.-/+ssso+:.`                                \n" +
"                                                                                            `./oyyo:/h/+ssso+:.`                                      \n" +
"                                                                                                 .:oys+:-`                                            ";
       
       imagens[2]="                                                                                                                                                                                                    \n" +
"                                                                                                                                                                                                                                                          \n" +
"        `/++//:-`                                                                                                                                                ``                                                                                       \n" +
"         yMMNNNNmdyo/:.`                                                                                                                 ``````````````````````````                                                                                       \n" +
"         `hMMMMNNNmNNNddy+-` ``                      ``                                                                        ``````````-````````````````````        `                                                                                   \n" +
"          .+mMMMMMNNmmmdmNhdysss+/////::////::--......`                                                             `   ``````/.`````````-`.````````-```..``````````````````                                                                              \n" +
"            -hMMMNMNNNNmNmhmmmhdNdyoo/::/::/++++ooosoooo+oo++/:-.`                                             `.``````.``````-.``-`````.```....:.`-.```````````````````````````````                                                                      \n" +
"             `/mMMMNNNMNNNmddmhNmymydysy+---:-:-:+so+oosso+ooysyym-                                 .. `````````-`````..``:.`````````````````.`````.``````````````````````````````````````                                                                \n" +
"               .sNMMNMMMNMNNNdmmmmdhhmyyyyyy+/:---++oooo+oooos+smN`                               ``````````:```.`````..``.``.``-.````` `:`  `     .` ``` . ``   `.  ````       ``````````````       `                                                    \n" +
"                 :hNMMMMNNNNNmNdNNmdmhmdhyhyddds+---/-://s++ooosmm``                        .`````.`````````.```.```````   .`   ``` -`. ``   `  ``      ` ``.`   `.  ```  ``            ````````                                                          \n" +
"                  `:hNMMMMNNNNMNNNNNdddmmddhhmmmhhs/::--/://++symm``                  ` ````````.`.``````````     `  `.`` ` ``````````.``````````````..`````.        .    ``                  ``` `.   . ``                                               \n" +
"                    `omMMMMMMNMNNNNNmmNNmddddddyymdNdso/+/:/++oomm-                `..`````.-`````````     ` ``   ````.-````.````````````````````````.```````````` `        `                   `   `.  ````   `                                          \n" +
"                     .+sdNMMMMNMMNNMNNNNNNmdhdddddshhhddho-:+oosNM-           ` ```````````.```` ``` ``  ` ` -.``````.````````````````````` `` .```````````.`````````````   `   `                   .. `````  ```                                         \n" +
"                      -++smMMMMMMMNNNNMNNNmdmmmNdhhhddddhddo++ssmMs`     `  ``.``````````     `   .```  ``` ````````````..``````````````````````````````` `.``` `      ``````````  `                . :.```` ````                                         \n" +
"                       :++:smMMMMMNMMNMNNNNmmmNmmNmdNdmhhdmNho++hNm:      ``````````   `    ```       ` `:``` ``````````-.```-.```````````````````.`.```` `  ``          `    ``` `                  .`.```.````                                          \n" +
"                       `:+/:/ymMMMMMMNNNMNNNmNNmmdmdmNmmhddmNNo++dNd`` ``` `   `              ` .``- `` `-`   ````.-`````````..``. ` `` .-.` ```````.``.`.. `   ``  `    `        `                .  ````  ````    ``                                    \n" +
"                        `:++:--shNMMMMMMNMMNNNNmNNmdmNmNNNdNmdosyomMs`         `       ``-`     `    `  .: ```````````.`     `` `.   `-`````-`  ```` `````````` ``  `       .                       ``.``  `````     ```                                  \n" +
"                         `:+o:---:sdNMMMNNMNMNNNNNNNNmNNhmhdmy..ohmmM/            .    ---`     `       `   `      :. . ``   :`` .   `-  ```.```       ``````...`` .                    `          ``-```  ````      ```                                  \n" +
"                          `/o+:-/-:-/ymMMMNMNNNNMNMNMMNmdmmdh/yo--mymm/``     `  `-    `                 . `        .  `+:   .:-  ` ``  `/:.``           ```./.`````      `        `   ````    ` ` ` ` `````.`        ```                                 \n" +
"                           .+++:------:odNMMMMNMMMNmMMmNNNmh:..+yhm:+dNo.`    `   ``      `      ``  `   - .      `          --   :`.```..``..            ``-:..```.  .  ``.          `````    ` -`` `   ``````       ``                                  \n" +
"                            -+o+/:-::/---+ymMMMNNNNNMNNNNy-:ss:-oN+-.+hmh/`    `.`      `      `` ``-. `-.` `-````-`:```````````````.`.`:.        .     `  `..-..``.` ````` `        ````    `   `````...`````        `  `   `.                           \n" +
"                             :oso+----------odNMMMMNNNNhsy:.`.+hm+/---/ydNy-   `/o/.              `.````-```.-``````-.````..-```````-``.:``.``.   - ``      .o+-.``.``-`````       `````    `: ```````..-.````          `/`                               \n" +
"                              /os++/:+:----:--+ydNNmdyd/.:ss/:hh+/:-::::sdNNs.   .+ho.    ` ```````.....----::----:-/:--..+-..-...```````````````        `- .-:-.````..````    ` ``````      ````-```` `````                                              \n" +
"                              `ooo+//:::---/------::-.:yy:.:ddo-:/+///+o+shmNm+`   `+dy:`.`````......-...---//----:://::+:y+//+:+-..--`.` .-`        `   -o``----``-...-.`    `.``..```     ``````  `-``````.            ```                              \n" +
"                            ` .-ys+o///:-------:------../ddy+-----:/+oooooydmNMmo` ` `oddo-..``````...---.-----::--o-::--:o/++:::/::-:.```--``       ```  `:--+-.``.-...``   `.....``      ``````. ``.`````        `.` ```` `                             \n" +
"                               `so+++/+s+---//----:-/+::-----/+++::/-://sooshmNMMmo:`.../hNy:```-..-:--:::/::/::///++++ossyo+/:/:::+///:++o---.      .`    `:/:-::.-....`` ```-...``     ```````. ``.````` - `    `````..``                               \n" +
"                           -    -yo+o+/////:---+:+/++s+/:-:::/oyy+ooo+////oyshhNNMMm+.````-yNms:----:::://oosssyyyyhyyyyhsyhyyyso+/:+:://+/:-.`` -`-  `  `-./o//-..:-/.`````....```.    ````...-``.`/-```  ` `  ``..``````                                \n" +
"                                `-hs++o+/++o++/+:+++++ossshdhddo:  ``:oyyssoohyyNNMMMy+.`.`.-odNdo+/++osyyhhyyyyyysssssssyssysssssso++:::/:/+:-.```:`````.::/+:--:---..`....-..-` `-  `````````.```.::-`  `   .-``..:.```                                 \n" +
"                        `         +ho++o++++o++sssssddmdh+:.`   .  `    `:+shyyyyhmNNmMd+..-.-:sdMNmdyyyyyyyyyyyyyysyysyysysysooo+/+os/:::-:::/o:.--``:.:.-://o./+:----.:--...``  ` `````.````:..:...-       `````....``               `                  \n" +
"                         .      `-`oho+oshsooosydmmmy/. `  . ` ``    `-  ` ``++yyhymdNNMNmo:/+ossshmMNdysssssssssssysyyyyysyso+//+---+o+:---:--:++/s:.``.//++/o/-::/:/::--..``  .````.`..````...-..``  - .  ```.:-...``                .`                 \n" +
"                                    ohooo+oyhdmhs:.        ``.--`-.` `.` ` ...``.-:+sydNNmNNdoooyysyhhNMNdso+++/+//+ooooo++++++os+:--:/o+:+::--/:+o/-..-/+sd+/:-:/::/::---.`   `.````.-`````.+/-..` `      `..:.--..``                                    \n" +
"                            `        +hhydhyo-` ``       `  `..:/:.``     `-````.````--:/+shhhssssoo+///smMd+-.---//oooo+////++oo/oo++///++:+:/o//ooo::/oo//::::////:--:-.`   `.`-...`````.:---...:`     ``.-----..``  `    `         `                   \n" +
"                        .             .:++.:.` ```     ` ` ` `-. :-//. ``.`````.```../:-:/oshoo+/:--......:smNy+/+ssssso+ossoo+/:-/oyso+//:/oss++/+++oo+oo/::oo++o/:::-:-` `.`.:--.````/+--:--.``      ``/::----:.`` ``               .                 ` \n" +
"                    `                `.`:.-``  `-:-.  ` `` .``. .`  `:o+-:````.````...-:+/++///mNds:`````..-/odNNdhhhhyyhhhy+s+/+oooosh+/+/+syo+/+oo+oo+s/:so+oo//o::-.`````.....``.-`.---:o-.`.     `.-:-/:-:...````````                                 \n" +
"                    `         -`   ` .-.-::`  `  `.:+:.`  `.`- ``   ``.:oy+-``.:``.-.-::/::::-.-/ymMNy+://ossyhhmNMNmmdhyyoyooyoossyooo/+oyyss++oyy+++oo+++ooso+//::--......-.`.```.:--/---..```   -`.--y:/:...````````               `                   \n" +
"                  ``                ``----.  `      `:/+:-.`.-  `- ``....-+yyo+:---:+///++///::-::/odNMNmmhhdmmmmmmdddysyssooosysssyyysossoo++hyshs+o+++ooooo++////----:/-..```-`:-/:-:/--.`````-``..------..`````````             -              .`      \n" +
"                                   `:-..:.-.`        ```:++/:.:```.....--.../sdhs+/+soossssso+ooosshhhmNMMMNNmdhhyyyyyyyyyysyhyhyssyssyyyyoooyyooo++ssosooo++o+/::--++-.-.::```.----/:/:/`-`````--.---/....`````````        `     ` `.                   `\n" +
"                                `  -:.../s`. ``          `.oso/.``.....--....:+ohdhsosyyyyyyyyhhdhddddddmdmNMNmdhhhhhyyyyyyyhyysssshysossyhsoo+sooossooos+s++s/:::/o::.`.`-.-/----::-..```.-`...------/-.``....````        ` `:`:``           .          `\n" +
"                  `     ``   `  ` `-.-:.```   .   -        .::/+/--.``.......-:/soydmhsooooyoyssyyyhhdyyhhhhdmNMMNddhhhyhyshysyyyyysoosyysooshsoooossooo+++/+:/://:::`.-`..--o:/o/--.````/./-.--+--....``......``          ```` ``    ```    ``         ``\n" +
"                        ```   `  `-.:.:.`.     `` -`   ``- `--..:o+:..:...-:--:/+osyydmmhyyyyyyssyhhhdhhhdddddddmmMMmddyhhhyyyysssyyysysoosoosssssoooos+++s/+///+::-:..--/+:o/:+/+.``......:-..-/+:`.........``           ``````   `````   `.          `` \n" +
"                    .   ```` ``````.:-:-.s/..`  ``.    ``` ./-:.`.-/+/-.-..:-:/++oossyyhhmNmdhhhddhddddddhhhdyyyyyhhmNNmdhydhsssssooooooyosysssosohooo+os++///::o/--///:///:+--.:/.....-::--....:-`........``          ` ``:  `` ``````:    `         ``` \n" +
"                    `    ```` `````---/::.-.-   .`` .` .-.`:-.-:-..-::/----:////++sssssysshdNmdhhysyyyyssyssyysydhhdddddmmydsosssossssyosssysysooooooo+o++/:--/-///+/o//s/::/....-...--:+:-:.`.``.......```            `````   ```````   `            ``  \n" +
"                          ``````````.::/--/.`..````:```:```-```.-/+/--+----:---:ooo++soso+oosshdds+ooossssyyyhddmhhyyssoysssssyo+yyosyyssosoysyssooo+/o++///+yo+os++//:::----../...-....-::/.`--......``             `````  ``.`````.``.             ``   \n" +
"                      ``   ````````.`-:+:://--:`.+`..`````.-...`.--::/+/++//:+///:///oo++oo+oooyydmhhyhhhhhhhyhyysosyosososo+ooosysssossssyossys++so/:--oso+o+++///::---/..:-...+--:...`.--.........```            .-``   ````-`````.               ````  \n" +
"                       .    ` ```.`-`--:::////::+:-:-.--/.-:/.-:o/--.---:++/o+o+ssossssydsyyhyhyyyhyhdhyyyssssysssoysosossyoosyyyssossyysyyo++/////:::++o+++++o//::-/.--...--.....:.:```.........```` `            ``    ```.```````.  `           ```    \n" +
"                                   ``.`-::/+////+///:--::--:..--...../..----:---:+/::+//+//+o+++o+sssssddysohysoyysooosoyyssooyssyyssyso+++////oo///+oooo+so/+o/-.-.-::-....:..``-.```-/:.:...```           `   .``` .:```````.````               ```     \n" +
"   ``                            `     ````---:/+o++o::/::-/--:/-:-o:/.:+::-:----:/::o+o+://s+++oosssyyysyysoso+oyoooyysossyyyysssoo+o+o++/+/++hyoososso++://.:-.....--.--..:/-``:....-:-..````              ` `-`  ``.```-````````              ```      \n" +
"                            `````````` `.  ..``.:--:///oo/:/:+so//+///+/s+/:/+++o++++oooyoo+sosossyoshso++o++oo+ooosysyhhhssss+++ooo+o+soosoosssssyo+o/:--./-.........``...`./:-:-:.--...````  `   `       `-.``  ``````.``````````             ```      `\n" +
"               ``           `:``````````  ```````-.:/---:o:///+h+//+o+//o+++/++osssoo+oossoyyoso+s++//+++ooysssyssysysoosss++++sosysoooossyyyyooo//:--.-...-....``.--.````.....-:.....```   ````       . ```.```````..``````-``                ```     `  \n" +
"``    `-.```                 `  `````.`````  ``````.:.-.::.---:////+++//++oo+++ooysooyoooooyooo+++++ooossssssssso+++++o++osyhyossssysssssyooo/---.::-.....`````..`.``...-.::.--...`..`````````     ``  +`.````````````````````               ```          \n" +
"   .``````-```.```                   `   ``  ``  ` `.```.......-.-:-/o://////o++/++/++/////s++++++oooooooo+++++++o+++ososssyhhhhyssooooo/::-::.:-...````````-.`.......:--..-.--``````````````     `   `````````-.````.``````                ```           \n" +
"   `  ```.```````.`````-`` ````````````          `   ````....--..:-....--::::--+--------://++o++ooo+++++oh+++++oossyyyyysysyssosyo+/::+-.:-....````````.``...--:-...----:..-`````````````         `.:`.:``````````.```````                 ```   `        \n" +
"         ```````````.``````.``.```.```.```.``````````.```.``.-.`.```.`:-`.`::..-.--::///++++oo++s+o+++ooooossysyyyssyy++++:+/++y//+//:--..```````..```-/----:-----..-..``:..``````````       `` ``...``.````.``..`.`.``                  ````   ``        \n" +
"             ``..`...`-......`--..-`.--.``..`.````.-..```....:--:-....::.---::::/+//++++o+++ooohsossoossssssossyos/++/:/:--::/-::..-::-.````.````-:.---:/:/-:-:....::.``.````````         ``  `...``````````````````.`                  ```               \n" +
"               `.``:.``---....-:-/.:::--...-......-:-....:..---++:/::::/:/:/+/+++++o+++oosooo+osoososhs+o+o+//o/::--:::--::---....`.``.--...-.--::::::--/-:/.``-`.``-.`````````         ``.-``.++````````..`.`````                     ```                \n" +
"     `          .`   ```-:`.`....---:/+:/:-/--:+/+://:::::/s/////+o+oso+ss+/++o+o+++o+/o++/s+++sooo/+y::----/--:/------...-..```.`````..-/oo/:://--/-./o.``.```.`-```.``````   `   `-   ```...``.``````.``.`````                   ` ``` `.               \n" +
"                         .:   `````-`-.:+o--.-::::+///:-::+o:+///+////ooos+//+::/+:+/+/+++++//:::------:----/---.....````````````.::::/://o+/+s:.....-`.``````````-````  `     `  ``.```...````````````-`````                      ```                    \n" +
"      `````              ``            ``.`````..-..--..-.::--.----:::::--:---..-/-o+:/::-//-..--.:-/-....-...`-.``````..``..--:::+:-:+-:-:...:o-.````.`.-...`````` `    :.    .` ``..:..``````````..`..``      `       ``     ` ``````                   \n" +
"        `   `                            `       . `   ````. ``-`:`..```:/:..-----.....-.-........-.`````````````````..--+:::::::--...-:``.``````:/```.```..`````       `   `..```..:..````````.``.````                     ` ";
               }

//Inicalização do Game
    static void menu(){
        //*MENU BASE INICIAL DO GAME**    
       System.out.println("------ \t PROJETO ESPERANÇA\t------");
       System.out.println("\t MENU DE OPÇÕES");
       System.out.println("| HISTORIA(1) |\t| SEGUIR AO GAME(2)|");
       
       teste = validador(teste);
       
       // Switch seguindo comando acima**     
       switch(teste){
           case '1':
               System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*");
               System.out.println("\n\t------\t RESUMO HISTORIA ------\n"
                       + "\t  Projeto Esperança\n"
                       +"No ano de 2050 com a terra em perigo por conta de erupções solares, após alguns desses eventos que causariam\n"
                       +"a destruição da camada de ozônio e sem ela estaríamos completamente expostos aos raios UV. Uma organização cientifica \n"
                       +"denominada OESU (Organização de Estudos Espaciais Unificada), depois de anos de pesquisas sobre esses ocorridos, fizeram\n"
                       +"um pronunciamento de que a Terra suportaria em média mais 80 anos. Toda essa exposição à radiação causaria a extinção\n"
                       +"da raça humana e junto mencionaram a pesquisa que eles já haviam dado andamento uns 30 anos antes sobre um planeta que tem\n"
                       +"todas as condições favoráveis a vida humana, tendo o encontrado, eles o chamaram de Esperança. Pensando nisso a OESU\n"
                       +"junto aos líderes das maiores nações iniciaram o Projeto Esperança.\n");
               System.out.println("*-----------------------------------------------------------------------------------------------------------------------------*\n");
               break;
           case '2':
               System.out.println("\n*--------------------------------------*\n");
               break;
       }
       imagens();
    }

//Osquetrador das Fnções / Rotas do jogo
    static char jogo(){
    // Declara Variaveis 
    
    //Arrays
    nave[0]=100; //Resistencia da Nave
    nave[1]=100; //Combustivel da Nave
    nave[2]=1;  //Uso do propulsor de velociade na luz
    
       // Inicio codigo do GAME**
       System.out.println("Voce é o comandante desta viagem!\n"
                        + "Como sua equipe deve chama-lo?");
       nome =  entrada.next();
       
       System.out.println("\n*-----------------------------------------------------------------------------------------------------------------------------*\n");
       System.out.printf("Estamos no ano de 2099 partimos nesta viagem a procura da Esperança, até o momentos tivemos poucos problemas\n"
               + "nada que não pudéssemos resolver, estamos indo bem nesta viagem, nave sem muitas avarias ou prolemas internos com a equipe.\n"
               + "Fim do relatorio!\n"
               +"Comandante %s deseja lista dos membros da equipe?\n", nome );
       System.out.println("1 para SIM e 2 para NÃO");
      
       teste = validador(teste);
       
       switch(teste){
           case '1':
                System.out.println("\n*--------------------------------------------------------------------------*\n");
                System.out.printf("Lista dos membros junto as funções de sua equipe incluindo você.\n"
                    + "Comandante, cientista e piloto da nave: %s\n"
                    +"Soldado das forças armadas e especialista em combate:\n"
                    +"Smith - 25 anos veio de New Jersey\n"
                    + "Medico especialista em atendimento em guerras:\n"
                    + "Dr. Pablo - 30 anos veio de Cuba\n"
                    + "Especialista em linguística com grande intelecto:\n"
                    + "Jessy - 26 anos veio de Hong Kong\n"
                    + "Mecanico de naves espaciais e engenheiro:\n"
                    + "Abud - 35 anos veio da India\n", nome);
                System.out.println("\n*--------------------------------------------------------------------------*\n");
                pausa(2);
                
           break;
           case '2':
               System.out.println("\n*--------------------------------------*\n");
           break;
       }
       System.out.println("Passamos pelo ponto de ignição, ja podemos escolher a rota apropriada!\n");
    
    //Função para temporizador! 
        pausa(3);
       
       System.out.println("*========================================================================================================================================================*");
       
        System.out.println(imagens[0]);
        
        System.out.println("*========================================================================================================================================================*");
        
        System.out.println("\nqueremos saber qual tipo de capitão você é, então responda a pergunta:\n"
                + "nessa missão iremos passar por situações dificeis, então em uma situação extrema você preza por?\n"
                + "1- vida dos seus colegas de equipe em primeiro lugar\n"
                + "2- completar a missão a qualquer custo\n"
                + "3- tenta encontrar um equilibrio entre os dois mesmo sendo arriscado, e com chances de falhar nos dois itens acima ");
        char dec = entrada.next().charAt(0);
        switch (dec){
            case '1':
               rota3();
               break;
            case '2':
                rota1();
                break;
            case '3':
                rota2();
                break;
            
        }
        
        System.out.println("\n\n\n");
        System.out.println("Gostaria de jogar novamente?");
        System.out.println("1 para SIM e 2 para NÃO");
        teste=validador(teste);
        
        return teste;
    }

//  Funções destiladas a Rota2    
    static void pularLinhas(int t){
        for (int i = 0; i < t; i++) {
            System.out.println("\n");
        }
    }
    
    static void carregando(){
        int t = 250;
        int t2 = 250;
        System.out.printf("C \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("A \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("R \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("R \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("E \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("G \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("A \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("N \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("D \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("O \n");
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf(". \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }
        System.out.printf(". \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }System.out.printf(". \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }System.out.printf(". \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }System.out.printf(". \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }System.out.printf(". \n \n");
        try {
            Thread.sleep(t2);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoPI.class.getName()).log(Level.SEVERE, null, ex);
        
    
        }
        
    }
    
    static void rota2(){
        pausa(2);
        pularLinhas(35);
        carregando();
        pularLinhas(35);
        System.out.println("********************************************************************\n"
                         + "*                      ATENÇÃO                                     *\n"
                         + "********************************************************************\n"
                         + "* Os dialogos =============== tratam de comentarios da sua equipe. *\n"
                         + "*                                                                  *\n"
                         + "* Já os dialogos ************* tratam da narrativa do jogo.        *\n"
                         + "*                                                                  *\n"
                         + "********************************************************************\n");
        pularLinhas(10);
        pausa(3);
        
        pularLinhas(30);
        System.out.println("==================================================================================================\n"
                         + " Comandante! Estamos a caminho de nossa base lunar. As expectativas para o planeta X ter condições\n"
                         + " para abrigar vida são gigantes.                                                                  \n"
                         + " Todo o planeta esta contando com a nossa jornada Comandante. Não podemos decepciona-los.         \n"
                         + "==================================================================================================\n");
        pularLinhas(5);
        pausa(3);
        
        pularLinhas(5);
        System.out.println("                  *****************************************************************\n"
                         + "                  * Você e sua equipe foram então a caminho dessa possibilidade.  *\n"
                         + "                  * O caminho na primeira semana foi extremamente tranquilo e não *\n"
                         + "                  * contou com nenhuma novidade, somente a rotina de uma viagem   *\n"
                         + "                  *****************************************************************\n");
        pularLinhas(5);
        pausa(2);        
                
        System.out.println("*************************************\n"
                         + "* Depois de quase um mes...         *\n"
                         + "*************************************\n");
        pularLinhas(5);
        pausa(5);
                
                
                
       System.out.println("===========================================================================\n"
                        + " Comandante, temos uma missão no seu aguardo. Precisamos que voce resolva  \n"
                        + " esse seguinte erro no processamento de dados digital que esta vindo de    \n"
                        + " forma errada da central de controle de combustivel. Caso nao for solucionado \n"
                        + " pode acontecer perda de combustivel na nave.    \n"
                        + "===========================================================================\n");
                        pularLinhas(5);
                        pausa(5);
                        System.out.println("******************************************\n"
                        + "* Voce vira para o painel de controle    *\n"
                        + "* da nave e verifica a seguinte mensagem:*\n"
                        + "******************************************\n");
       
System.out.print("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  C:\\> _ Console de Controle Central     |    |\n" +
"           |   |  Executando analise de erros....        |    |\n" +
"           |   |  ...                                    |    |\n" +
"           |   |  35% ...                                |    |\n" +
"           |   |  78% ...                                |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  Erro critico encontrado em placa de    |    |\n" +
"           |   |  combustivel que é responsavel pela     |    |\n" +
"           |   |  conversão analógica->digital           |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  Deseja corrigir erro? (SIM/NÃO)        |    |\n" +
"           |   |                                         |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'\n" +
""
+ "\n====================  Insira sua resposta: ");
                
                String resposta = entrada.nextLine();
                String resp1 = "SIM";
                String resp2 = "sim";
                
                boolean teste1 = resposta.equals(resp1);
                boolean teste2 = resposta.equals(resp2);
                
                
                while (teste1!=true && teste2!=true){
                    int menos = gerador.nextInt(20);
                    nave[0] = nave[0] - menos;    
                    resposta = entrada.nextLine();    
                    System.out.println(resposta);
                    teste1 = resposta.equals(resp1);
                    teste2 = resposta.equals(resp2);
                    System.out.println(nave[0]);
                    
                }
        pularLinhas(25);
        System.out.printf("**************************************************************************************************************\n"
                        + "* Após verificar alguns cabos soltos e constatar que nao tinha nenhum erro físico o comandante, no caso voce *\n"
                        + "* foi direto para a correção do problema em Software.                                                        *\n"
                        + "**************************************************************************************************************\n"
                        + "\n \n"
                        + "*******************************************                                                                   \n"
                        + "*...   Então eis o problema encontrado:   *                                                                   \n"
                        + "*******************************************                                                                   \n \n"
+ "  ======================================================================================================\n" +
" |                                       PAINEL DE ENTRADA LÓGICA:                                     |\n" +
"  ======================================================================================================\n" +
" | Expressão Lógica do sistema AH-81c para cálculo de entrada |S = (~A.~B.C) + (A.~B.C)+(A.B.~C)|      |\n" +
" |       __________________________                                                                    |\n" +
" |      |   A    |  B  |  C  |  S  |     3 erros encontrados na transferência de informações           |\n" +
" |      |   0    |  0  |  0  |  0  |     Carregando diagnostico automático....                         |\n" +
" |      |   0    |  0  |  1  |  1  |     ....                                                          |\n" +
" |      |   0    |  1  |  0  |  0  |     ....                                                          |\n" +
" |      |   0    |  1  |  1  |  #  |     Não foi possível executar o diagnostico automático            |\n" +
" |      |   1    |  0  |  0  |  0  |     *********************************************************     |\n" +
" |      |   1    |  0  |  1  |  #  |     *  Favor insira em sequência o resultado faltante “#” em*     |\n" +
" |      |   1    |  1  |  0  |  #  |     ** sequencia ininterrupta:                              *     |\n" +
" |      |   1    |  1  |  1  |  0  |     *********************************************************     |\n" +
" |       ---------------------------                                                                   |\n" +
"  ===================================================================================================== \n \n \n \n \n \n \n \n \n \n"
                + " \n \n \n Insira sua resposta de maneira continua. EXEMPLO: 555 ou 154 ou 888: ");             
         
                String respostaDesafio = entrada.nextLine();
                
                
                if (!"011".equals(respostaDesafio)){
                    nave[0] = nave[0] - (int)(nave[0]*0.4);    
                    pularLinhas(30);
                    System.out.println("================================================================================================================\n"
                                     + "Capitão você errou a resposta. Perdemos 40% do combustivel e agora estamos com "+nave[0]+"% da reserva da nave. \n"
                                     + "=================================================================================================================\n \n"+
"                                                         `.-/+osssssooo++++++++ooossssso+/:.\n" +
"                                                   `-/osss+/:.```                    ```.-/+osso/-`                                                   \n" +
"                                              `-/oss+:.`                                      ``-/oss+-`                                              \n" +
"                                          `-+ss+:``                      ````                      ``-+ss+-`                                          \n" +
"                                       `/ss+-`              .-:/+oooossssooooosssoooo+/:-.              `-+ss/.                                       \n" +
"                                    ./ss/.`           .:+osso+:-.`````          `````.-:/osso+:.`           ./ss/.                                    \n" +
"                                 `:ss/.          .:+sso/-``                                ``-/+ss+:.          `/ss/`                                 \n" +
"                               .+y+.         `:+so/-``                                           `./oso:`         .+yo-                               \n" +
"                             -ss:`        ./ss+-`                                                    `-/ss/.        `:ss:                             \n" +
"                           -ss-`       `:ss/.`                           .//-                            ./ss/`        -oy:                           \n" +
"                       .oy:       `:ss:`                                `N-`N.                                `-os:`       -ss.                       \n" +
"                     `/y/`      `:yo-                                   `N-`N.                                   .oy/`       :y+`                     \n" +
"                    .ys.       :yo.        ..                           `N-`N.                                     .oy/`      `oy-                    \n" +
"                   /h:       .ss-          :do.                         `N-`N.                                       .oy-       -h+`                  \n" +
"                 `oy.      `+y:             -dmo.       .//-            `N-`N.            .//.                         -yo`      `ss`                 \n" +
"                .yo`      -yo`               .ymho.     hs:d/           `N-`N.           :d/od                          `+h-       +h.                \n" +
"               .h+       /h:                  `sh+yo.   /d.-d:          `N-`N.          -d:.h+                            -h+`      /h-               \n" +
"              .d/      `oy.             ``      +h:/y+.  +h.:d-        `.N-`N-`        .d/`ho               ``             `ys`      :d:              \n" +
"             .d/      `ss`             ssso-     :h:`/y+. oh`/d-.:/+oooooy.`yooooo+/:..h+`ys              .osoy`            `oy`      :d-             \n" +
"            `h+      `ys              `ho.:ss-`   .h+``/y+.yy /s+//:::::///////:::::/+s+ oh.            -oy/.+d`              oh.      /d.            \n" +
"            ys      `ys                `/yo-:ss:`  `ys` `+hd+.-/+ooo+//:------://+oos+/-`:oso:`       -sy:.oy/`                oh`      +h`           \n" +
"           +h`      oy`                   :ys--oy:` `yh.  `+yds:.`                  `.:+ss+-:+so-` `:ss:-oy:`                   sy       ys           \n" +
"          -m-      /d`                      -ss:-oy+ss+d-   `+y/`                        `:oso--oy+yo--ss:                      `h+      .m:          \n" +
"          ho      .m-             `````````   -oy:.:.:syd/    `+y/`                          :ss:.:-:ss-   ``````````            .m-      /d`         \n" +
"         :m`      ys             oyoooooosh`    .oy+yo. .ho`    `+y/`                          .oy+yo.     yyooooooyy             +h       d+         \n" +
"         h+      -m`             yo -////+m.      `.`    `sy`     `oy/`                          `.`       d/ -////sd             `d/      /d         \n" +
"        -m`      yo              yo oh-----                +h.      `oy/`                                  d/ sy----.              /d      `m:        \n" +
"        oy      .N.              yo oy                      :d:       .sh/--.``                            d/ ss                   `m:      sy        \n" +
"        d/      +h               yo ohoooo                   -d+    .+sso+//+oss+.                         d/ sy:::.                ss      :m`       \n" +
"       `N.      yo               yo `...:N`  ``               `ys`.sy/`        `:ys.       ``              d/ .///yy                /d      `N-       \n" +
"       -N       m:  ````         ho odoooo   ``                 shd/   .+ssss+.   /d:      ``              d/ +hssyo                .N`      d/       \n" +
"       /d      `N.```          ``ho sy```    ``    ```    ```   `N/   oh:````-hy`  :m.``   ``    ````    ``d+ ss````   ``    ```    `N-      h+       \n" +
"       +h      .N.``          ```yo oy`````  ``   ```       ``` /m`  /d` ```  `do   d+``   ``      ```  ```d/ ss  ```   ``` ``       m:      yo         ");
                pausa(5);    
                }else{
                    pularLinhas(35);
                    System.out.println("   ==============================================================================================\n"
                                     + "   Conseguimos Comandante. A resposta digitada estava correta e portanto não perdemos combustivel.\n"
                                     + "   =============================================================================================="
                                     + "\n \n \n \n"
                                     + " ===============================================================================================\n"
                                     + " O  indice de combustivel de nossa nave esta em "+nave[0]+" e continuamos a nos mover em direção\n"
                                     + " a nossa missão rumo a esta nova Terra.\n"
                                     + " ===============================================================================================");
                    pularLinhas(10);
                    pausa(4);
                    
                }
        
                pularLinhas(3);
                    
       
        
        System.out.println("========================================================================================================================================================\n"
                          +" Estamos fora de perigo, pelo menos por enquanto comandante, e nossos sensores atestam estarmos com |- "+nave[0]+" -| porcento do tanque de combustivel.\n"
                          +"========================================================================================================================================================\n"
                          +" \n \n \n \n");
        pausa(2);
        System.out.println("***************************************************************\n"
                         + "* Após ter conseguido arrumar a pane do painel logico da nave *\n"
                         + "* a missão até a base foi seguindo como planejada.Até mesmo   *\n"
                         + "* após algumas batidas frontais da nave em alguns corpos      *\n"
                         + "* celestes e desvios quase que de raspão em um planeta ou     *\n"
                         + "* outro a missão estava até então de acordo.                  *\n"
                         + "***************************************************************");
                pularLinhas(5);
                pausa(20);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println(" Ao menos até entao...\n");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                System.out.println("\n .");
                pausa(1);
                
                System.out.println("============================================================================================\n"
                                 + " COMANDANTE!!!! Temos um grupo de 6 naves em nossa retaguarda.\n "
                                 + " Ela esta atigindo velocidades proximas a nossa e a mesma\n "
                                 + " não aparenta ser amistosa e ....\n"
                                 + "============================================================================================\n"
                                 + "\n \n \n \n"
                                 + "********************************************************************************************\n"
                                 + "* Neste momento ela foi enterrompida por uma subita ativação do painel central da nave,    *\n"
                                 + "* onde o comandante consegue fazer a comunicação com naves proximas.                       *\n"
                                 + "* Um ser que aparentava ser um sapo humanoide, com um sobretudo preto e uma insignia de um *\n"
                                 + "* grupo de piratas da Anã Branca 154ZZ em comunicação clandestina direta com a nossa nave. *\n"
                                 + "* Ele então se pronunciou e fez o seguinte pedido:                                         *\n"
                                 + "********************************************************************************************\n");
                                 
                                 pularLinhas(15);
                                 pausa(30);
                
                pularLinhas(30);
                System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                               + "@ Ola Comandante e sua tribulação, não queremos vossas vidas, tao menos sua nave,   @\n"
                               + "@ mas precisamos do seu combustivel.                                                @\n"
                               + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
                pularLinhas(1);
                pausa(5);                        
                        
                System.out.print( "******************************************************************************\n"
                                + "* Sem nenhum aviso sua nave simplesmente parou e as luzes entraram em modo   *\n"
                                + "* de emergencia e pela janela você viu tubos se conectando ao tanque da nave *\n"
                                + "******************************************************************************\n"
                                + "\n \n \n"
                                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                                + "@ Podemos estar negociando. Você tem "+nave[0]+" e eu quero 30 de seu combustivel. @\n"
                                + "@ Ou isso ou a destruição.                                                         @\n"
                                + "@ Oque acha?                                                                       @\n"
                                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
                pularLinhas(2);
                pausa(3);
                System.out.println("========= Tentar fugir por um buraco negro, caso negativo ou outra resposta estara aceitando a proposta? [sim/nao]\n");
                
                String respostaET = entrada.nextLine();
                if (!"sim".equals(respostaET) || !"Sim".equals(respostaET) || !"SIM".equals(respostaET)){
                    nave[0]=nave[0]-30;
                    if(nave[0]<=0){
                        fimCombustivel();
                    }
                               System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                                                + "@ Muuuuito bem, muuuito bem HAHAHAHA   @\n"
                                                + "@ Agora queremos TUDO HAHAHAHHAHA      @\n"
                                                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");    
                pausa(5);
                }
                
                System.out.println("****************************************************\n"
                                 + "* Foi necessario então que se coloca-se  a nave    *\n"
                                 + "* em modo de alta velocidade e assim atingindo     *\n"
                                 + "* a velocidades proxima a da luz e que encontrasse *\n"
                                 + "* um buraco de minhoca.                            *\n"
                                 + "****************************************************\n");
               pausa(5);
               pularLinhas(40);
               System.out.println("**********************************************\n"
                                + "*  PAINEL DE CONTROLE CENTRAL DE VELOCIDADE  *\n"
                                + "**********************************************\n");
                
              System.out.print("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  C:\\> _ Console de Controle Central    |    |\n" +
"           |   |  Executando calculo de velocidade....   |    |\n" +
"           |   |  ...                                    |    |\n" +
"           |   |  35% ...                                |    |\n" +
"           |   |  78% ...                                |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  Necessario calculo de velocidade para  |    |\n" +
"           |   |  se atingir a velocidade                |    |\n" +
"           |   |                                         |   |\n" +
"           |   |  Sendo v a velocidade maxima (em milhao)|    |\n" +
"           |   |  QUAL SER A VELOCIDADE MAXIMA DA NAVE?  |    |\n" +
"           |   |          f(v) = –v2 + 9                 |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'\n" +
""
                      + "");
              String respostaDesafio2 = entrada.nextLine();
              
              if (!"9".equals(respostaDesafio2)){
                    pularLinhas(35);
                    System.out.println("================================================\n"
                                     + "   Comandante voce errou. Perdemos a batalha    \n"
                                     + "================================================\n");
                    pausa(4);
                    fimCombustivel();
                    
              }else {
                      System.out.println("==============================================\n"
                                       + "         PERFEITO!! Conseguimos comandante!!! \n"
                                       + "==============================================\n");
                      } 
              pausa(4);
              pularLinhas(5);
              System.out.println("********************************************************\n"
                                +"* Depois de uma longa e emocionante aventura na rota   *\n"
                                +"* na busca pelo planeta que tanto precisariam a sua    *\n"
                                +"* tripulação se saiu vencedora. Com um total de        *\n"
                                +"*"+nave[0]+" porcento de combustivel.                  *\n"
                                +"********************************************************\n");
             pausa(4);
             
             System.out.println("*************************************************************\n"
                              + "* Unica coisa que dividia voce e sua tripulação era a       *\n"
                              + "* falta de proteção contra os raios da estrela mais proxima  *\n"
                              + "* e precisou fazer uma parada em Nebulos 54N para atualizar *\n"
                              + "* seus escudos UV.                                          *\n"
                              + "*************************************************************\n");
             pausa(2);
             pularLinhas(2);
             System.out.println("===================================================================\n"
                              + " Comandante, é de extrema importancia o calculo exato de proteçção.\n"
                              + " Caso acontecer algum erro perderemos a nossa nave.                \n"
                              + "===================================================================\n");
            pausa(2);
            pularLinhas(2);
            System.out.println("*****************************************************\n"
                             + "* Então você abre seu bloco de anotações e começa a *\n"
                             + "* fazer todos os calculos necessarios e uma questão\n"
                             + "* te veio a mente....\n"
                             + "*****************************************************\n");
            
            pausa(2);
            pularLinhas(2);            
            System.out.println("== A taxa em Watts de seu escudo era de 30000W e decai a 1300W a cada ano de uso ==.\n"
                             + "== Desta maneira, qual será sua taxa (em W) atual após 4 anos de uso?            ==\n");
            int respostaDesafio3 = entrada.nextInt();
            if (respostaDesafio3!=24400){
                    pularLinhas(35);
                    System.out.println("===================================================================================\n"
                                     + "   Comandante voce errou. Perdemos a nossos escudos e queimou nosso combustivel    \n"
                                     + "===================================================================================\n");
                    pausa(3);
                    fimCombustivel();
                    return;
              }else {
                      System.out.println("==============================================\n"
                                       + "         PERFEITO!! Conseguimos comandante!!! \n"
                                       + "==============================================\n");
                      } 
              pausa(5);
              pularLinhas(5);    
              System.out.println("**********************************************\n"
                               + "* Após isso voces conseguiram entrar na rota *\n"
                               + "* final, rumo a Esperança....                *\n"
                               + "**********************************************\n");
              pausa(2);
    
              esperança('2');
    }
    
    static void fimCombustivel(){
        System.out.printf("____    ____  ______     ______  _______    .______    _______ .______       _______   _______  __    __   __   __   __  \n" +
"\\   \\  /   / /  __  \\   /      ||   ____|   |   _  \\  |   ____||   _  \\     |       \\ |   ____||  |  |  | |  | |  | |  | \n" +
" \\   \\/   / |  |  |  | |  ,----'|  |__      |  |_)  | |  |__   |  |_)  |    |  .--.  ||  |__   |  |  |  | |  | |  | |  | \n" +
"  \\      /  |  |  |  | |  |     |   __|     |   ___/  |   __|  |      /     |  |  |  ||   __|  |  |  |  | |  | |  | |  | \n" +
"   \\    /   |  `--'  | |  `----.|  |____    |  |      |  |____ |  |\\  \\----.|  '--'  ||  |____ |  `--'  | |__| |__| |__| \n" +
"    \\__/     \\______/   \\______||_______|   | _|      |_______|| _| `._____||_______/ |_______| \\______/  (__) (__) (__) \n" +
"\n" +
"\n" +
"\n" +
"Sua nave acabou todo o combustível e você não chegou a seu destino.\n" +
"\n" +
"\n" +
"...\n" +
"\n" +
"\n" +
"Sua nave ficou a deriva no espaço durante 20 anos. Você nesse meio tempo acabou enlouquecendo.\n" +
"\n" +
"\n" +
"...\n" +
"\n" +
"Depois desse tempo a sua nave entrou na zona gravitacional de um planeta gigante gasoso chamado THZ-201125.\n" +
"A nave caiu nesse planeta a velocidades surreais, até ser explodida perto da superfície gelatinosa do planeta.\n" +
"\n" +
"     _.-^^---....,,--       \n" +
" _--                  --_  \n" +
"<                        >)\n" +
"|                         | \n" +
" \\._                   _./  \n" +
"    ```--. . , ; .--'''       \n" +
"          | |   |             \n" +
"       .-=||  | |=-.   \n" +
"       `-=#######=-'   \n" +
"          | ;  :|     \n" +
" _____.,-#########~,._____");
        pausa(5);
 
    }
    
//  Função para a chegada ao planeta
    static void esperança (char perguntas){
        String cod="37CE"; // armazenando a senha do teste
        if(nome.equals("Salvador")){}
        else{
        System.out.printf("ABUD: Comandante estamos nos aproximando do planeta!\n"
                + "Temos uma base proximo a ele, poderiamos parar nela e tentar contato com os nativos.\n");
        System.out.printf("%S: Boa ideia Abud, vamos entrar na base então", nome);
        
        System.out.println("\nSua equipe se direcionou para a base.");
        
        System.out.print("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  SISTEMA DE SEGURANÇA ENTRADA NA BASE   |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  DECODIFIQUE O COMANDO A SEGUIR PARA    |    |\n" +
"           |   |  TER ACESSO A SENHA DE ENTRADA          |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |         0011 0111 1100 1110             |    |\n" +
"           |   |                                         |    |\n" +
"           |   |       INSIRA A SENHA CORRETA            |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'\n" +
""
+ "\n====================  Insira sua resposta: ");
        cod=entrada.next(); // entrada de dados para comparar com a String com a senha correta, resposta certa : 37CE
        cod=cod.toUpperCase();
        
        if(cod.equals("37CE")){
            System.out.print("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  SISTEMA DE SEGURANÇA ENTRADA NA BASE   |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  DECODIFIQUE O COMANDO A SEGUIR PARA    |    |\n" +
"           |   |  TER ACESSO A SENHA DE ENTRADA          |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |         0011 0111 1100 1110             |    |\n" +
"           |   |                                         |    |\n" +
"           |   |       INSIRA A SENHA CORRETA            |    |\n" +
"           |   |               "+cod+"                   |    |\n" +
"           |   |           SENHA CORRETA                 |    |\n" +
"           |   |                                         |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'\n");
            System.out.println("Entrada na base com sucesso");
            System.out.println("Voces fizeram uma busca por suprimentos na base.\n"
                    + "Após alguns testes conseguiram contactar os nativos. E sua entrada no planeta foi autorizada.");
            
        }
        else{
            System.out.print("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  SISTEMA DE SEGURANÇA ENTRADA NA BASE   |    |\n" +
"           |   |                                         |    |\n" +
"           |   |  DECODIFIQUE O COMANDO A SEGUIR PARA    |    |\n" +
"           |   |  TER ACESSO A SENHA DE ENTRADA          |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |         0011 0111 1100 1110             |    |\n" +
"           |   |                                         |    |\n" +
"           |   |       INSIRA A SENHA CORRETA            |    |\n" +
"           |   |                 ****                    |    |\n" +
"           |   |           SENHA INVALIDA                |    |\n" +
"           |   |                                         |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'\n");
            
            System.out.println("Sua equipe opitou em não tentar mais a entrada na base\n"
                    + "Seguindo assim direto ao planeta sem ter informações sobre os nativos.");
        }
        }    
        
        System.out.print (CSI + "32" + "m");        // mudar a cor da saida de dados
        System.out.println("\t------------------------------------\n");
        System.out.print (CSI + "32" + "m");
        System.out.println("\tVocês chegaram no planeta esperança\n");
        System.out.print (CSI + "32" + "m");
        System.out.println("\t------------------------------------\n");
        pausa(2);
        System.out.println("A atmosfera é quase identica a da Terra, é completamente possivel ter vida humana.\n"
                + "mas existe algumas estruturas pelo planeta, ja existe uma raça desconhecida habitando o planeta\n"
                + "não parece ser uma raça muito avançada, porem devem ter um bom nivel de inteligência.");
        System.out.println("-------------------------------------------------------------------------------------------");
        switch(perguntas){      // switch com o parâmetro da função
            case '1':   // se a pessoa jogou a rota 1, vai cair nesse teste
                // testes para cada personagem sacrificado
        if (personagens [0].equals("0")){
            System.out.println("!!ATENÇÃO!!");
        System.out.printf("Os nativos estão nos atacando\n"
                + "%S- nós estamos sem o soldado smith, não temos chance contra eles\n"
                + "Todos os integrantes morreram, por conta da sua má escolha, em sarificar o soldado\n",nome);
        System.out.print (CSI + "31" + "m");
        System.out.println("GAME OVER!!");
        return;
        }else if(personagens [1].equals("0")){
            System.out.println("Você pousou em uma area muito perigosa do planeta\n"
                    + "em uma area habitado por animais violentos, que danificou a nave\n "
                    + "e sem o mecânico Abud, vocês não conseguiram consertar a tempo, os animais selvagens entraram em sua nave\n"
                    + "e mataram todos os integrantes");
            System.out.print (CSI + "31" + "m");
        System.out.println("GAME OVER!!");
        return;
        }else if (personagens [2].equals("0")){
            System.out.println("Vocês precisam se comunicar com os nativos, para poder dividir o planeta\n"
                    + "como a Jessy especialista em linguística foi sacrificada, o mecanico abud vai tentar se comunicar com eles \n"
                    + "abud acabou ficando nervoso por não conseguir se comunicar e agrediu um nativo\n"
                    + "os nativos se revoltaram e mataram todos os integrantes da equipe");
            System.out.print (CSI + "31" + "m");
        System.out.println("GAME OVER");
        return;
        }else if (personagens [3].equals("0")){
            System.out.println("Vocês pousaram em uma floresta com arvores de coloração nunca vista antes\n"
                    + "e sairam da nave para olhar de perto, porem todos começaram a passar mal\n"
                    + "a arvore soltava gases venenosos, e o Dr Pablo foi sacrificado, ele era especialista\n"
                    + "em antidotos, todos morreram intoxicados");
            System.out.print (CSI + "31" + "m");
            System.out.println("GAME OVER\n");
            return;
        }else
            System.out.println("A equipe pousou no planeta, e fizeram varios testes, e cada um integrante ficou encarregado de fazer algo\n"
                    + "O soldado Smith ficou responsavel pela segurança do grupo, caso os nativos atacassem\n"
                    + "O mecânico Abud, ficou fazendo alguns reparos na nave para viagem de volta a Terra para buscar o resto da humanidade\n"
                    + "A especialista em linguas Jessy, ficou responsavel por tentar se comunicar com os nativos e tentar entrar em um acordo\n"
                    + "para que as duas raças pudessem viver em harmonia\n"
                    + "O Dr Pablo, fez exames nos integrantes, e escolheu quem estava com o corpo menos desgastado com essa longa viagem\n"
                    + "para voltar para Terra, e os outros ficariam no esperança estabelecendo uma relação com os nativos.");
                    System.out.print (CSI + "32" + "m");
                System.out.println("\tMISSÃO CONCLUÍDA");
        break;
        
        
            case '2': // caso a pessoa tenha jogado a rota 2, ira cair neste teste
            System.out.println("Vocês pousaram no planeta, no meio das estruturas dos nativos\n"
                    + "eles não parecem muito amigaveis, podemos tentar se comunicar com a ajuda da nossa especialista em linguistica Jessy,\n"
                    + "ou deixar que nosso soldado Smith cuide deles, a escolha é sua:\n"
                    + "1-Jessy\n"
                    + "2-Smith");
            // reposta certa: 1
        teste = entrada.next().charAt(0);
        switch (teste){
            case'1':
                System.out.println("Jessy precisou de dois dias para conseguir se comunicar com os nativos\n"
                        + "eles aceitaram dividir o planeta, boa escolha "+nome);
                System.out.println("Agora, vocês vão voltar para a Terra e buscar uma parte da população\n"
                        + "não tera como trazer todos, não existe naves suficiente, porem a raça humana foi salva, parabéns");
                 System.out.print (CSI + "32" + "m");
                System.out.println("\t\t MISSÃO CONCLUíDA");
            return;
            case '2':
                System.out.println("Você escolheu o soldado Smith\n"
                        + "ele acabou matando um dos nativos, e todos se revoltaram, e contra atacaram");
                System.out.print (CSI + "31" + "m");
                fimMorte(); // função responsavel pela mensagem de fim de jogo
                return;
        }
            case '3': // caso a pessoa tenha jogado a rota 3, ira cair neste teste
                System.out.println("Vocês pousaram em um lugar que parece ser uma fortaleza alien\n"
                        + "e precisam traduzir oque os nativos estão falando:");
            System.out.println(nome+"- Jessy conseguiu traduzir oque eles estão falando?\n"
                    + "Jessy - ainda não, so consegui passar para codigo binario, preciso decodificar\n"
                    + "\n01101110 01110101 01101110 01100011 01100001 00100000 01101001 01110010 01100101\n"
                    + "01101101 01101111 01110011 00100000 01100100 01101001 01110110 01101001 01100100\n"
                    + "01101001 01110010 00100000 01101111 00100000 01110000 01101100 01100001 01101110 \n"
                    + "01100101 01110100 01100001\n"
                    + "Aperte (1) para usar o decodificador");
            teste = entrada.next().charAt(0);
            switch (teste){
                case '1':
                    System.out.println("codigo traduzido:\n"
                            + "nunca iremos dividir o planeta");
                    break;
                    
            }
                System.out.println(nome+"- atenção não a outra alternativa, que não seja lutar, precisamos salvar a humanidade\n"
                        + "Smith dê armas para todos os integrantes!\n"
                        + "você esta em uma batalha rode os dados: ");
                System.out.println(imagens[1]);
                int dados = gerador.nextInt(100); // numero aleatório, reponsável por determinar o final do jogo
                pausa(3);
                if(dados>=50){
                    System.out.println("vocês ganharam a batalha, conteve todos os nativos");
                    System.out.println("apesar de alguns imprevistos, a missão foi um sucesso, vocês voltaram para pegar o resto da humanidade...");
                    System.out.print (CSI + "32" + "m");
                    System.out.println("\t\tMISSÃO CONCLUIDA");
                }else if(dados<50){
                    System.out.println("o soldado Smith acabou morrendo, e sem ele não conseguimos vencer a batalha...\n");        
                    System.out.print (CSI + "31" + "m");
                    System.out.println("GAME OVER");  
                }          
        }                    
    }
    // função para a rota 1
    static void rota1 (){
       // populando o vetor com os nomes dos personagens para o teste final
    personagens [0]="Smith"; 
    personagens [1]="Abud";
    personagens [2]="Jessy";
    personagens [3]="Pablo";
    String senha2 = "2617";
    int dador=0;
       
    System.out.printf("você esta na galaxia anã de Cetus terá que achar o caminho para o esperança\n "
                + "você precisa ligar o propulsor de velocidade da luz da nave, porem você e ninguem da sua equipe sabe ligar\n"
                + "e esqueceram o manual da nave na Terra!\n"
                + "jogue o dado veremos se você tem sorte\n"
                + "você escolhe rodar 1 dado ou 2?\n ");
    teste = entrada.next().charAt(0);  // escolha de quantos dados rodar
    switch (teste){
        case '1':
            int dado =gerador.nextInt(100); 
            dador = dado;   // atribuindo valor aleatório em uma variavel para teste
        break;
        case '2':
            dado =gerador.nextInt(50);
            int dado2 =gerador.nextInt(50);
            dador = dado+dado2;
        break;
    }
    System.out.println(imagens[1]); // função com imagens em caracteres.
    System.out.println("rodando dados...");
    pausa(3);       //função para pausar o game por um tempo, passando um parametro que sera os segundos de pausa.
    if (dador<50){
         System.err.println("você apertou o botão errado e acabou abrindo a escotilha principal da nave, isso danificou alguns circuitos da nave");
        nave[0]=nave[0]-50;   // descontando um valor do vetor responsavel pela resistencia da nave 
    }else
        
    System.out.println("parabéns vocês conseguiram apertar o botão do propulsor\nvocê esta a caminho do esperança ");
        System.out.print (CSI + "31" + "m");  // responsavel por mudar a cor da saída
    System.out.println("atenção!!");
    System.out.println("a uma estrutura desconhecida a frente, parece ser uma base alienigena\n"
             + "la pode conter suprimentos e peças para arrumar sua nave, porem você não sabe oque te espera la dentro\n"
             + "deseja explorar?\n"
             + "1-sim\n"            // resposta certa: 2
             + "2- não");           
    char teste3 = entrada.next().charAt(0);
    switch (teste3){
        case '1':
            System.out.println("você e sua equipe chegou na porta da estrutura, mas ela esta trancada e com uma senha, com a seguinte questão:\n"
                     + "passe o valor 101000111001 para base decimal\n"
                     + "digite a senha: ");
            String senha = entrada.next();  
            // resposta certa: 2617
            while (!senha.equals(senha2)){  // laço para aparecer uma mensagem enquanto a senha não for a correta.
                System.out.print (CSI + "31" + "m");
                System.out.println("senha invalida, digite novamente:");
                senha = entrada.next();
            }
            System.out.println("você conseguiu entrar\n"
                     + "porem dentro da base havia uma criatura de origem desconhecida e acabou matando todos integrantes da equipe ");
            System.out.print (CSI + "31" + "m");
            System.out.println("GAME OVER");
            return;             // fim do jogo por ter feito uma má escolha 
         case 2:
            System.out.println("ok, você preferiu não colocar sua tripulação em perigo e arriscar o futuro da humanidade");
            break;
     }
            System.out.println("");
            char esc;
    System.out.println("você foi um bom lider e escolheu não arriscar a vida da sua equipe\nvocê esta a caminho do planeta esperança...\n");
    System.out.println("vocês estão a alguns anos luz do esperança, porem vocês estão passando do lado de um planeta que aparentemente tem a mesma atmosfera da terra\n"
            + "sua nave esta pesada e nela contem algumas naves acopladas para caso a tripulação precisasse seguir caminhos diferentes, com o peso atual dela\n"
            + "vocês não conseguirão chegar ao planeta com o que resta de combustivel, portanto um integrante tera que se sacrificar e desaclopar com uma nave, para a nave principal\n"
            + "economizar combustivel, mas você tem a opção de arriscar todos entrando dentro do planeta aparentemente habitavel e talvez salvar um integrante da sua equipe\n"
            + "a escolha é sua:  ");
    System.out.println("escreva (explorar) ou (seguir)");   //resposta certa: seguir
    String teste2 =entrada.next();
    teste2=teste2.toLowerCase(); // mudar toda entrada de dados para letra minuscula, para evitar erros
    
    switch  (teste2){
        case "explorar":
            System.out.println("vocês estao entrando na atmosfera do planeta...");
            pausa(2);
            System.out.println("vocês sairam da nave\n"
                            + "jessy- parece ser habitavel, consigo ver montanhas no horizonte\n"
                            +"abud- não é montanha jessy, são ondas enormes!!!\n"          
                            +nome+ "- todos voltem para a nave agora!!!\n"
                            +"não deu tempo de vocês chegarem na nave, o planeta era composto apenas por água\n"
                            + "e ondas que passavam os cem metros, todos se afogaram"); 
            System.out.print (CSI + "31" + "m");
                    System.out.println("GAME OVER");
                    return;
           
          
        case "seguir":
            System.out.println("ok, você escolheu sacrificar um integrante da sua equipe\nagora terá que escolher quem ira desacoplar da nave principal:\n"
                    + "1-soldado smith\n"
                    + "2-mecanico Abud\n"
                    + "3-Jessy\n"
                    + "4-Dr Pablo");
            System.out.println("você tambem pode se sacrificar no lugar de seus companheiros\n5-para sacrificar você "+nome); // para continuar o jogo o usuario devera se sacrificar
            esc =Character.toLowerCase(entrada.next().charAt(0));   // mudar toda entrada de dados para letra minuscula, para evitar erros
            
            switch (esc){       // switch para atribuir um valor no vetor de pergonagens, caso ele seja sacrificado.
                case '1':
                    personagens [0]="0";
                    System.out.println("O soldado Smith aceitou e desaclopou da nave, agora sua equipe tem 4 integrantes ");
                    break;
                case '2':
                    personagens [1]= "0";
                    System.out.println("O mecânico Abud, aceitou edesaclopou da nave, agora sua equipe tem 4 integrantes");
                    break;
                case '3':
                    personagens [2] = "0";
                    System.out.println("Jessy aceitou e desaclopou da nave, agora sua equipe tem 4 integrantes");
                    break;
                case '4':
                    personagens [3]= "0";
                    System.out.println("Dr. Pablo aceitou edesaclopou da nave, agora sua equipe tem 4 integrantes");
                    break;
                case '5':
                    System.out.println(nome+" morreu por uma boa causa, talvez você seja o maior salvador da humanidade,"
                            + "e seu nome seja lembrado por toda eternidade");
                    nome="Salvador";
                    break;
                    
            }   
 } 
        System.out.println("estamos chegando ao nosso destino");
        System.out.println("\nentrando na atmosfera do planeta esperança...");
        pausa(2); // função para pausar o codigo, passando um parâmetro que sera os segundos de pausa
        esperança('1'); /*cada final de rota vai chamar a função da chegada do planeta, passando um parametro diferente que sera responsavel em mudar
                         as perguntas de acordo com a rota jogada*/
        
 }
   
//  Funções destiladas a Rota3  
    static void rota3(){
    //Funçao referente a rota de nº3
    //Espaço para declarar variaveis
    int resp;
    
        System.out.println("\n*--------------------------------------------------------------------------------------------------------------------------------------------------------*\n");    
        nave[0]=nave[0]-gerador.nextInt(10);
        nave[1]=nave[1]-gerador.nextInt(10);
        
        System.out.println("Escapamos de uma nebulosa, porem fomos jogados nesta rota..\n");
        
        System.out.printf("ABUD: Comandante %s, ela parece mais curta do que a rota original.\n"
                + "Eu tenho um relatorio sobre problemas causado na nave, gostaria de ouvi-lo? \n",nome);
        
        System.out.println("*Descida se vai ou não responder SIM(1) e NÃO(2)*");
        teste = validador(teste);
        
        switch(teste){
            case '2':
                System.out.printf("\n%S: Sim, iremos por essa rota.\n"
                        + "Não preciso disso no momento! Pode se retirar.", nome);
                break;
            case '1':
                System.out.printf("\n%S: Sim, iremos por essa rota.\n"
                        + "Pois bem Abud, diga o seu relatorio.\n"
                        + "\n", nome);
                pausa(1);
                System.out.printf("ABUD: Tivemos um dano no casco da nave, porem ele se encontra com %d%% \n"
                        + "Combustivel ainda se encontra com %d%% da capacidade\n"
                        + "São apenas este dados que tenho a mostrar, no geral a nave ainda "
                        + "se encontra em bom estado comandante.\n"
                        , nave[0], nave[1]);
                break;
        }
        
        pausa(3);
        System.out.println("\n*--------------------------------------------------------------------------*\n");
        System.out.println("Seguimos por esta rota sem problemas até então");
        System.out.println("\n*--------------------------------------------------------------------------*\n");
        System.out.printf("%S: Abud como esta nossa reserva de combustível?\n"
                + "E o quão longe ainda estamos?\n", nome);
       
        nave[1]=nave[1]-gerador.nextInt(20);
        
        System.out.printf("\nABUD: Comandante nosso tanque se encontra com %d%% de sua capacidade no momento!\n"
                + "Mas o porque da pergunta comandante?\n", nave[1]);
        System.out.println("*Descida se vai ou não responder SIM(1) e NÃO(2)*");                
        teste = validador(teste);
        
        switch(teste){
            case '2':
                System.out.printf("%S: Por nada, obrigado Abud!\n",nome);
                break;
                
            case '1':
                System.out.printf("\n%S: Porque com base no tanto de combustivel estou pensando em ativar os propulsores \n"
                        + "de velocidade da luz com o intuito de sair dessa rota e retomarmos o nosso caminho inicial.\n"
                        + "Afinal não conhecemos este lado da galaxia ou pelos menos não cogitamos tomar este caminho.\n", nome);
                
                pausa(1);
                System.out.print("\nABUD: Entendi sua ideia, é possivel fazer isso com a quantidade de combustivel, porem\n"
                        + "agora eu ainda acho precipitado usar neste momento comandante.\n");
                break;
            default:
        }
                        
                System.out.print("\n*--------------------------------------------------------------------------*\n");
                
                System.out.print("\n!!!!ALERTA!!!!\n");
                
                System.out.printf("SMITH: COMANDANTE, TEM UMA NAVE NOS PERSEGUINDO!\n"
                        + "ELA NÃO PARECE NADA AMIGAVEL\n"
                        + "MUITO MENOS DEIXAR A GENTE SEGUIR.\n");
                
                System.out.print("**Trocar de piloto da nave?**\n | 1 | SIM  --  | 2 | NÃO\n");
                teste = validador(teste);
                
                switch(teste){
                    case '2':
                        System.out.println("\nEscolha errada!\n"
                                + "Comandante pode ate ser piloto, mas não tem habilidade em combate\n");
                        fimMorte();
                    break;
                    case '1':
                        System.out.printf("\n%S: SMITH TOME O COMANDO DA NAVE, AFINAL VOCÊ É O NOSSO ESPECIALISTA EM ARMAS.\n",nome);
                        System.out.println("\nSmith: Ok Comandante, me encarregarei de cuidar deste problema.");
                        
                        System.out.println("\n**Escolha como proseguir com o problema adiante**");
                        System.out.println("1 - Para usar armas em nave inimiga");
                        System.out.println("2 - Para acionar os propulsores de velocidade da luz");
                        teste = validador(teste);
                        
                        switch(teste){
                            case '1':
                                System.out.println("\nSmith: Entrando em batalha que a sorte esteja conosco");;
                                resp = gerador.nextInt(10);
                                if(resp>=4){
                                    pausa(2);
                                    System.out.println("\nSeu ataque foi efetivo");
                                    System.out.println("Nave inimiga abatida");
                                    nave[0]=nave[0]-gerador.nextInt(15);
                                    
                                    pausa(1);
                                    System.out.printf("\nABUD: Dano em nossa nave foi bem menor do que o calculado,\n"
                                          + "resistência em %d%% podemos seguir\n", nave[0]);
                                }
                                else{
                                    nave[0]=nave[0]-30;   
                                    System.out.println("\nApos 3 ataques, nave inimiga abatida");
                                    System.out.printf("\nABUD: Dano em nossa nave foi bem consideravel, porem ainda podemos\n"
                                          + "seguir, resistencia da nave se encontra em %d%%\n", nave[0]);
                                    System.out.print("\n*--------------------------------------------------------------------------*\n");
                                }
                            break;
                            case '2':
                                if(nave[2]==1){
                                    System.out.println("SMITH Pessoal estou acionando o propulsor de velociade na luz.");
                                    nave[2]=nave[2]-1;
                                    System.out.println("Conseguimos despistar eles, podemos continuar nossa viagem");
                                    System.out.print("\n*--------------------------------------------------------------------------*\n");
                                
                                    pausa(2);
                                }
                                else{
                                    System.out.println("\nSMITH: COMANDATE ESTÁ IMPOSSIVEL ACIONAR O PROPULSOR, ACHO QUE NOS ESTAMOS SEM RESERVA.");
                                    pausa(1);
                                    System.out.printf("%S: ABUD VERIFIQUE NOSSA RESERVA \n",nome);
                                    pausa(1);
                                    System.out.println("ABUD: COMANDANTE ELE TEM RAZÃO, NÃO PODEMOS USA-LO!!");
                                    pausa(1);
                                    System.out.printf("%S: SMITH USE AS ARMAS ENTÃO!!\n", nome);
                                    pausa(1);
                                    System.out.println("SMITH: IMPOSSIVEL, ELAS FICAM INUTILIZAVEIS POR UM TEMPO APOS ACIONAR O PROPULSOR,\n"
                                            + "MESMO QUE ELES NÃO LIGARAM ELAS VÃO DEMORAR UM POUCO.\n");
                                    pausa(1);
                                    System.out.println("FALHA EM ACIONAR ARMAS E PROPULSORES");
                                    System.out.print("\n*--------------------------------------------------------------------------*\n");
                                    pausa(1);
                                    fimMorte();

                                }
                            break;
                          }
                        
                        pausa(2);                      
                        System.out.println("\nApós passarmos por este problema, seguimos o caminho por um tempo, sem saber se haveria mais imprevistos.");
                        
                        nave[1]=nave[1]-gerador.nextInt(30);
                        System.out.println("\n*RELATORIO SOBRE NAVE*");
                        System.out.printf("ABUD: Comandante a resistencia da nave está em %d%% e o combustivel está em %d%%,\n"
                                + "podemos proseguir viagem sem ter outros problemas.\n", nave[0], nave[1]);
                        
                        System.out.print("\n*--------------------------------------------------------------------------*\n");
                        
                        pausa(2);
                        System.out.println("\nSua equipe seguiu a rota da melhor forma possivel, afim de chegar ao planeta de destino,\n"
                                + "porem ainda que estivesse tudo bem, essa rota parecia ser tranquila demais.");
                        
                        System.out.print("\n*--------------------------------------------------------------------------*\n");
                        
                        pausa(2);
                        System.out.println("Seguimos, por um tempo sem esperar por problemas, passamos por planetas inabitáveis,\n"
                                + "satélites,cometas ... \n");
                        
                        System.out.print("\n*--------------------------------------------------------------------------*\n");
                        
                        System.out.println("\nABUD: Comandante estamos pegando mais velocidade rumo aquele planeta ou é apenas impressão minha? ");
                        
                        pausa(3);
                        System.out.printf("\n%S: Agora que você comentou é verdade, eu acabei me distraindo aqui no comando e nem percebi\n", nome);
                        
                        pausa(3);
                        System.out.println("\nJESSY: Licença comandante, não tenho tanta experiencia na area de astrofisica, mas um corpo tal força\n"
                                + "gravitacional ao ponto de puxar a nossa nave, poderia ser um buraco negro?\n");
                        
                        pausa(3);
                        System.out.println("ABUD: Não queria concordar com ela, mas aparentemente nos ganhamos mais velocidade em direção ao 'buraco negro'...");
                        
                        pausa(1);
                        System.out.printf("\n%S: Pessoal se segurem vou acionar o propulsor\n", nome);
                        
                        if(nave[2]==1){
                            
                            System.out.println("*Propulsor ativo*\n"
                                    + "Fuga do campo gravitacional do buraco negro com sucesso.\n"); 
                            pausa(8);
                            System.out.println(imagens[2]);
                            
                            pausa(3);
                            esperança('3');
                            
                        }
                        else{
                            System.out.println("Falha ao acionar propulsor..\n");
                            System.out.println("ABUD: Comandante tínhamos só uma reserva para o uso do propulsor e o usamos para fugir da batalha,\n"
                                    + "impossivel usa-lo agora não temos outra saida, a velocidade na nave não é o bastante e a força do campo gravitacional é forte demais.");
                            
                            fimMorte();
                        }
                        
                        break;
                        }
                        
                  
                }
    
     static void fimMorte(){
        System.out.print("Morte dos membros da equipe\n"
                + "FIM DO JOGO!!\n\n");
    }
    
    
    
    
                        
                
    public static void main(String[] args) {
       do{
        menu();
        teste=jogo();
       
       }   
        while(teste=='1');
    }
        
                
                
        
  
    
   
}