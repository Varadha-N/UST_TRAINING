package com.streamapi;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo
{

    public void streamDemo(){
        List<Movies> movies = List.of(
                new Movies("a",30,Genre.ROMANTIC),
                new Movies("b",10,Genre.THRILLER),
                new Movies("c",50,Genre.ACTION),
                new Movies("d",20,Genre.COMEDY),
                new Movies("e",40,Genre.ROMANTIC)
        );

        var genericResult = movies.stream()
//                .collect(Collectors.groupingBy(Movies::getGenre,Collectors.toSet())); // find Sets
                .collect(Collectors.groupingBy(Movies::getGenre,Collectors.counting())); // find counts {SCIFI=h, ACTION=a,s, ROMANTIC=c, FANTACY=d}
//                .collect(Collectors.groupingBy(Movies::getGenre,Collectors.mapping(Movies::getTitle,Collectors.joining(",")))); //find by commas {SCIFI=h, ACTION=a,s, ROMANTIC=c, FANTACY=d}
        System.out.println(genericResult);



//        var result = movies.stream()
//                .filter(m -> m.getLikes() > 10)
//                .map(Movies::getTitle)
//                .collect(Collectors.joining(","));
//        System.out.println(result);


//        var result1  = movies.stream()
//                .filter( m -> m.getLikes() >10)
//                .collect(Collectors.toMap(m -> m.getTitle(), m-> m.getLikes()));
                //.collect(Collectors.toSet());
                //.collect(Collectors.toList());
     //   System.out.println(result1);

//        var result = movies.stream()
//                .allMatch(m -> m.getLikes() <20);
//        System.out.println(result);
//
//        movies.stream()
//                .filter(m -> m.getLikes()>10)
//                .peek(m -> System.out.println("filtered "+m.getTitle()))
//                .map(Movies::getTitle)
//                .peek(t -> System.out.println("mappped "+t))
//                .forEach(System.out::println);
//
//
//
//        movies.stream()
//                .skip(2)
//                .forEach(m -> System.out.println(m.getTitle()));
//
//
//
//
//        Predicate<Movies> isPopular = m -> m.getLikes() > 10;
//        movies.stream()
//                .filter(isPopular)
//                .forEach(m -> System.out.println(m.getTitle()));
//
//
//
//        movies.stream()
//                .filter(m -> m.getLikes() > 10)
//                .forEach(m -> System.out.println(m.getTitle()));
//
//
//
//        movies.stream()
//                .map(movie -> movie.getTitle() )
//                .forEach(name -> System.out.println(name));
    }

}
