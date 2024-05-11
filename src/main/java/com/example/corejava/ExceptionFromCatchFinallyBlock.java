package com.example.corejava;

/**
 * When try and finally block throws exception
 * finally block eat try block exception
 */
public class ExceptionFromCatchFinallyBlock {

    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } finally {
            throw new RuntimeException("from finally");
        }
    }
}
/**
 * OUTPUT ::
 * Exception in thread "main" java.lang.RuntimeException: from finally
 */
