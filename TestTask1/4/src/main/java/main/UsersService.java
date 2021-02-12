package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void save(UserEntity user) {
        usersRepository.save(user);
    }

    public Iterable<UserEntity> findAll() {
        return usersRepository.findAll();
    }

    public Optional<UserEntity>  findById(int id) {
        return usersRepository.findById(id);
    }

    public void deleteAll() {
        usersRepository.deleteAll();
    }

    public void  deleteById(int id) {
        usersRepository.deleteById(id);
    }

    public void  saveAll(List<UserEntity> userEntities) {
        usersRepository.saveAll(userEntities);
    }
}
