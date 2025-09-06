package Estrutura.Atv1;

public class Main {
    public static void main(String[] args) {
        Apartamento apartamento = new Apartamento();
        apartamento.popularApartamentos();
        apartamento.printMoradores();
        System.out.println("Total moradores: " + ProcessaAps.moradoresTotal(apartamento.getMoradores()));
        System.out.println("Apartamentos vazios: " + ProcessaAps.apsVazios(apartamento.getMoradores()));
        System.out.println("Andar mais cheio: " + ProcessaAps.andarMaisCheio(apartamento.getMoradores()));
    }
}
