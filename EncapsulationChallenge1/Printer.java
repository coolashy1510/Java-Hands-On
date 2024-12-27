package com.io.Java11.EncapsulationChallenge1;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >=0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        int tempAmount = tonerLevel + tonerAmount;

        if (tempAmount < 0 || tempAmount > 100) {
            return -1;
        }
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    // duplex - if true: two pages will get printed on 1 sheet of paper
    //          else : 1 page will get printed on each paper
    public int printPages(int pages) {
        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;

        pagesPrinted += jobPages;

        if(duplex) {
            System.out.println("It is a duplex Printer..");
        }

        return jobPages;
    }
}
