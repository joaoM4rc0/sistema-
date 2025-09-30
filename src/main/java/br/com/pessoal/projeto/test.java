package br.com.pessoal.projeto;

import java.util.UUID;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
        }
    }
}
