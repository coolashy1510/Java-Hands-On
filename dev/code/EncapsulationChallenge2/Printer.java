package com.io.Java11.dev.code.EncapsulationChallenge2;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel > -1 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            int tempAmount = tonerLevel + tonerAmount;
            if (tempAmount > 100) {
                return -1;
            }
            tonerLevel += tonerAmount;
            return tonerLevel;
        }
        return -1;
    }

    // duplex - if true: two pages will get printed on 1 sheet of paper
    //          else : 1 page will get printed on each paper
    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (duplex) {
            pagesToPrint = (duplex) ? (pages / 2) + (pages % 2) : pages;
        }
        pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }
}
