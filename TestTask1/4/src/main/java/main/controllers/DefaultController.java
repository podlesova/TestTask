package main.controllers;

import main.UserEntity;
import main.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class DefaultController {

    private  final UsersService usersService;

    @Autowired
    public DefaultController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("error","");
        model.addAttribute("users",getEntities());
        return "index";
    }

    @PostMapping("/add")
    public String addSave(Model model,
                          @RequestParam(name = "id", required=false, defaultValue ="-1") int id,
                          @RequestParam(name = "name", required=false, defaultValue ="") String name,
                          @RequestParam(name = "phone", required=false, defaultValue ="") String phone,
                          @RequestParam(name = "email", required=false, defaultValue ="") String email
                          ){
        if (name.equals("")||phone.equals("")){
            model.addAttribute("error","Имя и телефон - обязательные поля");
        }
        else{
            model.addAttribute("error","");
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(email);
            userEntity.setName(name);
            userEntity.setPhone(phone);
            if (id != -1) {
                Optional<UserEntity> optionalUserEntity = usersService.findById(id);
                if (optionalUserEntity.isEmpty())
                    model.addAttribute("error","Введен несуществующий номер записи");
                else
                    userEntity.setId(id);}
            if (Objects.equals(model.getAttribute("error"), ""))
                usersService.save(userEntity);
        }
        model.addAttribute("users",getEntities());
        return "index";
    }

    public List getEntities(){
        Iterable<UserEntity> userEntityIterable = usersService.findAll();
        ArrayList<UserEntity> users = new ArrayList<>();
        for (UserEntity user : userEntityIterable){
            users.add(user);
        }
        return users;
    }

    @PostMapping("/")
    public String loadFile(@RequestParam("file") MultipartFile file, Model model){
        try
        {   ArrayList<UserEntity> list = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .forEach((l) -> {
                        String[] fragments = l.split(",");
                        if (fragments.length > 1) {
                            UserEntity userEntity =  new UserEntity();
                            userEntity.setName(fragments[0]);
                            userEntity.setPhone(fragments[1]);
                            if (fragments.length > 2)
                                userEntity.setEmail(fragments[2]);
                            list.add(userEntity);
                        }
                        });

            usersService.saveAll(list);
            model.addAttribute("errorFile","");
            model.addAttribute("users",getEntities());
        }
        catch (Exception ex) {
            model.addAttribute("errorFile","Ошибка загрузки файла");
        }

        return "index";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id", required=false, defaultValue ="-1") int id , Model model){
        Optional<UserEntity> userEntity = usersService.findById(id);
        if (userEntity.isPresent())
          usersService.deleteById(id);
        model.addAttribute("users",getEntities());
        return "index";
    }
}
