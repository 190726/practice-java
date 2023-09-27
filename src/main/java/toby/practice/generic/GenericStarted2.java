package toby.practice.generic;

public class GenericStarted2 {

    interface Reserve<T>{
        T reserve();
    }

    static class MovieAgency implements Reserve<Movie>{ // T type is Movie
        @Override
        public Movie reserve() { // T Type is Movie
            System.out.println("movie");
            return new Movie();
        }
    }

    static class Movie {

    }

    public static void main(String[] args) {
        Reserve<Movie> r = new MovieAgency();
        Movie reserve = r.reserve();
        System.out.println(reserve.toString());
    }

}
