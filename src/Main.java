import Service.boardgameServices;
import entidades.boardgame;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sorte");
        boardgameServices bs = new boardgameServices();


        System.out.println("Insire 5 elementos na táboa boardgame");
//        bs.crearBoardgame("Catan", "Kosmos", 4, 90, 1995);
//        bs.crearBoardgame("Carcassonne", "Hans im Glück", 5, 45, 2000);
//        bs.crearBoardgame("Gloomhaven", "Cephalofair Games", 4, 120, 2017);
//        bs.crearBoardgame("Terraforming Mars", "Stronghold Games", 5, 120, 2016);
//        bs.crearBoardgame("Wingspan", "Stonemaier Games", 5, 70, 2019);

        System.out.println("Lista tódo-los elementos da táboa boardgame");

        bs.mostrarLista(bs.listarBoardgames());


        System.out.println("Selecciona de db os boardgames publicados despois do 2015 e sube a súa duración 120 minutos");

        bs.actualizarDuracion(2015);


        System.out.println("Lista de db os boardgames modificados");

        bs.mostrarLista(bs.listarBoardgames());


        System.out.println("Borra tódo-los boardgames");


        bs.borrarTodo();
        bs.mostrarLista(bs.listarBoardgames());

        System.out.println("Insire 5 elementos na táboa anime");




        System.out.println("Lista tódo-los elementos da táboa anime");


        System.out.println("Selecciona de db os anime de menos de 30 capítulos e duplica o número de capítulos");


        System.out.println("Lista de db os animes modificados");


        System.out.println("Borra tódo-los animes");


        System.out.println("Insire 5 elementos na táboa videoxogos");


        System.out.println("Lista tódo-los elementos da táboa videoxogos");


        System.out.println("Selecciona de db os videoxogos cunha plataforma diferente de PC e cambia o valor por EMULADO");


        System.out.println("Lista de db os videoxogos de Nintendo");


        System.out.println("Borra tódo-los videoxogos");


        System.out.println("Insire 5 elementos na táboa army40k");


        System.out.println("Lista tódo-los elementos da táboa army40k");


        System.out.println("Borra tódo-los army40k que non sexan Adepta Sororitas");

    }
}