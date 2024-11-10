package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MonopatinRepository;


@Service
public class MonopatinService {

    @Autowired
    private MonopatinRepository monopatinRepository;


}
