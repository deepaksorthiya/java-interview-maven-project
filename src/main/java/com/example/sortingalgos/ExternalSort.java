package com.example.sortingalgos;

import java.io.*;
import java.util.*;

/**
 * Java program for implementation of External Sort
 * <a href="https://www.geeksforgeeks.org/external-sorting//">GFG Link</a> </a>
 */
public class ExternalSort {

    private static // A class for Min Heap
    class MinHeapNode {
        int element; // The element to be stored
        int i; // index of the array from which the element is
        // taken

        public MinHeapNode(int element, int i) {
            this.element = element;
            this.i = i;
        }
    }

    // Merges k sorted files
    public static void mergeFiles(String output_file, int n,
                                  int k) throws IOException {
        PriorityQueue<MinHeapNode> harr
                = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.element));
        BufferedReader[] in_files = new BufferedReader[k];
        BufferedWriter out = new BufferedWriter(
                new FileWriter(output_file));

        // Open output files in read mode.
        for (int i = 0; i < k; i++) {
            in_files[i] = new BufferedReader(
                    new FileReader(String.valueOf(i)));
            String element = in_files[i].readLine();
            if (element != null) {
                harr.add(new MinHeapNode(
                        Integer.parseInt(element), i));
            }
        }

        while (!harr.isEmpty()) {
            // Get the minimum element and store it in
            // output file
            MinHeapNode root = harr.poll();
            out.write(root.element + "\n");

            // Find the next element that will replace
            // current root of heap.
            String element = in_files[root.i].readLine();
            if (element != null) {
                harr.add(new MinHeapNode(
                        Integer.parseInt(element), root.i));
            }
        }

        // close input and output files
        for (int i = 0; i < k; i++) {
            in_files[i].close();
        }
        out.close();
    }

    // Using a merge-sort algorithm, create the initial runs
    // and divide them evenly among the output files
    public static void createInitialRuns(String input_file,
                                         int run_size,
                                         int num_ways)
            throws IOException {
        BufferedReader in_file = new BufferedReader(
                new FileReader(input_file));
        BufferedWriter[] out_files
                = new BufferedWriter[num_ways];

        boolean more_input = true;
        int next_output_file = 0;

        while (more_input) {
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < run_size; i++) {
                String line = in_file.readLine();
                if (line != null) {
                    data.add(Integer.parseInt(line));
                } else {
                    more_input = false;
                    break;
                }
            }

            // sort array using merge sort
            Collections.sort(data);

            // write the records to the appropriate scratch
            // output file
            out_files[next_output_file]
                    = new BufferedWriter(new FileWriter(
                    String.valueOf(next_output_file)));
            for (int i : data) {
                out_files[next_output_file].write(i + "\n");
            }
            out_files[next_output_file].close();

            next_output_file++;
            if (next_output_file == num_ways) {
                next_output_file = 0; // Reset to 0 if it reaches num_ways
            }
        }

        // close input file
        in_file.close();
    }

    // For sorting data stored on disk
    public static void
    externalSort(String input_file, String output_file,
                 int num_ways, int run_size)
            throws IOException {
        // read the input file, create the initial runs, and
        // assign the runs to the scratch output files
        createInitialRuns(input_file, run_size, num_ways);

        // Merge the runs using the K-way merging
        mergeFiles(output_file, run_size, num_ways);
    }

    // Driver code
    public static void main(String[] args)
            throws IOException {
        // No. of Partitions of input file.
        int num_ways = 10;

        // The size of each partition
        int run_size = 1000;

        String input_file = "input.txt";
        String output_file = "output.txt";

        // generate input
        try (BufferedWriter f = new BufferedWriter(
                new FileWriter(input_file))) {
            Random rand = new Random();
            for (int i = 0; i < num_ways * run_size; i++) {
                f.write(rand.nextInt(10000) + "\n");
            }
        }

        externalSort(input_file, output_file, num_ways,
                run_size);
    }
}

