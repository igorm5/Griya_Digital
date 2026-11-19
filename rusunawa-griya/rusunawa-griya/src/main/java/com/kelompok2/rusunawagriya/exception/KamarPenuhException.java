package com.kelompok2.rusunawagriya.exception;

public class KamarPenuhException extends RuntimeException {
    public KamarPenuhException(String nomorKamar) {
        super("Maaf, kamar " + nomorKamar + " sudah dipesan atau penuh.");
    }
}