package pl.mps.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Forum {

    private final List<ForumUser> users;

    public Forum(List<ForumUser> users) {
        this.users = users;
    }

    public List<ForumUser> getUsers() {
        return users;
    }

    public static void main(String[] args) {
        Forum forum = init();
        Map<Integer, ForumUser> userMap = forum.getUsers()
                .stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> LocalDate.now().minusYears(20).isAfter(u.getBirth()))
                .filter(u -> u.getPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getId, Function.identity()));
        print(userMap);
    }

    private static Forum init() {
        return new Forum(Arrays.asList(
                new ForumUser(1, "Jan Kowalski", 'M', LocalDate.of(1976, Month.MAY, 12), 10),
                new ForumUser(2, "Anna Ko0walska", 'K', LocalDate.of(1997, Month.JULY, 1), 1),
                new ForumUser(3, "Piotr Nowak", 'M', LocalDate.of(2002, Month.MAY, 13), 10),
                new ForumUser(4, "Gracjan Nowacki", 'M', LocalDate.of(1979, Month.DECEMBER, 29), 0),
                new ForumUser(5, "Marcin Kaczmarski", 'M', LocalDate.of(1987, Month.JANUARY, 11), 1)
        ));
    }

    private static void print(Map<Integer, ForumUser> userMap) {
        userMap.forEach((key, value) -> System.out.println(String.format("%d -> %s", key, value)));
    }
}
