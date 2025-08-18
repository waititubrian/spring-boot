package com.codewithbrian.springboot;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Software Engineer with id " + id + " does not exist");
        }
        softwareEngineerRepository.deleteById(id);
    }

    @Transactional
    public SoftwareEngineer patchSoftwareEngineerById(Integer id, SoftwareEngineer updates) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Software Engineer with id " + id + " not found"));

        if (updates.getId() != null) {
            engineer.setId(updates.getId());
        }

        if (updates.getName() != null) {
            engineer.setName(updates.getName());
        }
        if (updates.getTechStack() != null) {
            engineer.setTechStack(updates.getTechStack());
        }

        return softwareEngineerRepository.save(engineer);
    }
}
