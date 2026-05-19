package repository;

import model.showroom.Showroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ShowroomRepository {
    private final List<Showroom> showrooms = new ArrayList<>();

    public Showroom save(Showroom showroom) {
        deleteById(showroom.getId());
        showrooms.add(showroom);
        return showroom;
    }

    public boolean deleteById(String id) {
        return showrooms.removeIf(s -> s.getId().equals(id));
    }

    public Optional<Showroom> findById(String id) {
        return showrooms.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public List<Showroom> findAll() {
        return Collections.unmodifiableList(showrooms);
    }
}
