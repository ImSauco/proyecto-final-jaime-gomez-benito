package com.keepcoding.controller.view;

import com.keepcoding.entity.Mascota;
import com.keepcoding.service.MascotaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MascotaViewController {

    @Autowired
    private MascotaService mascotaService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        binder.registerCustomEditor(LocalDate.class, new java.beans.PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDate.parse(text, dateFormatter));
            }
        });
    }
    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 5;
        Page<Mascota> mascotasPage = mascotaService.getMascotasPage(page, size);
        model.addAttribute("mascotasPage", mascotasPage);
        return "index";
    }

    @GetMapping("/mascotas/{id}")
    public String getMascotaById(@PathVariable Long id, Model model) {
        model.addAttribute("mascota", mascotaService.getById(id).orElse(null));
        return "mascota";
    }

    @GetMapping("/mascotas/nombre")
    public String getMascotaByNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("mascotas", mascotaService.getByNombre(nombre));
        return "mascota";
    }
    @GetMapping("/mascotas/youngest")
    public String getYoungest(Model model) {
        int size = 20;
        Page<Mascota> youngestMascotas = mascotaService.getYoungest(size);
        model.addAttribute("mascotasPage", youngestMascotas);
        return "mascota";
    }

    @GetMapping("/mascotas/nueva")
    public String nuevaMascotaForm(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "nueva-mascota";
    }

    @PostMapping("/mascotas/nueva")
    public String nuevaMascotaSubmit(Mascota mascota) {
        mascotaService.save(mascota);
        return "redirect:/";
    }

    @GetMapping("/mascotas/delete/{id}")
    public String deleteMascota(@PathVariable Long id) {
        mascotaService.deleteById(id);
        return "redirect:/";
    }
}
