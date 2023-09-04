package com.example.quizzapplication;

import static com.example.quizzapplication.Questionans.choices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

     class QuizManager {
         private List<Question> questions;


         public QuizManager() {
             initializeQuestions();
         }

         private void initializeQuestions() {
             questions = new ArrayList<>();
             for (int i = 0; i < Questionans.question.length; i++) {
                 questions.add(new Question(Questionans.question[i], Questionans.choices[i], Questionans.correctAnswers[i]));
             }
             // Shuffle the questions
             Collections.shuffle(questions);
         }



        public Question getNextQuestion() {
            if (questions.isEmpty()) {
                return null; // No more questions
            }
            return questions.remove(0);
        }
    }

    public class Questionans {
        public static String question[] = {

                "What does HTML stand for?",
                "Which programming language is known for its use in machine learning and artificial intelligence?",
                "What is the purpose of the SQL SELECT statement?",
                "In computer networking, what does the acronym LAN stand for?",
                "Which data structure follows the Last In, First Out (LIFO) principle?",
                "What is the binary representation of the decimal number 25?",
                "Which of the following is not a sorting algorithm?",
                "What is the purpose of the if statement in programming?",
                "Which data structure is used to implement a dictionary in Python?",
                "What does HTTP stand for in the context of web development?"

        };




        public static String choices[][] = {
                {"Hyperlink Text Markup Language", "Hyper Text Markup Language", "Hyper Transfer Markup Language", "Hyperlink and Text Markup Language"},
                {"Java", "Python", "C++", "Ruby"},
                {"To delete data from a database", "To insert data into a database", "To retrieve data from a database", "To update data in a database"},
                {"Local Area Network", "Longitudinal Access Node", "Logical Area Network", "Link Access Node"},
                {"Queue", "Stack", "Linked List", "Tree"},
                {"11001", "11101", "10011", "10100"},
                {"Merge Sort", "Breadth-First Search", "Quick Sort", "Insertion Sort"},
                {"Looping", "Function definition", "Conditional execution", "Variable declaration"},
                {"Array", "Linked List", "Dictionary", "Hash Table"},
                {"HyperText Transport Protocol", "HyperText Transfer Protocol", "HyperText Terminal Protocol", "HyperText Testing Protocol"}
        };

        public static String correctAnswers[] = {

                "Hyper Text Markup Language", // Question 1
                "Python",                     // Question 2
                "To retrieve data from a database", // Question 3
                "Local Area Network",         // Question 4
                "Stack",                      // Question 5
                "10011",                      // Question 6
                "Breadth-First Search",       // Question 7
                "Conditional execution",      // Question 8
                "Hash Table",                 // Question 9
                "HyperText Transfer Protocol" // Question 10

        };
    }





