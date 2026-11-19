package com.kelompok2.rusunawagriya.controller;

import com.kelompok2.rusunawagriya.service.AdminVerifikasiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/admin/verifikasi")
public class AdminVerifikasiController {

    private final AdminVerifikasiService adminVerifikasiService;

    public AdminVerifikasiController(AdminVerifikasiService adminVerifikasiService) {
        this.adminVerifikasiService = adminVerifikasiService;
    }

    @GetMapping
    public String halamanVerifikasi(Model model) {
        model.addAttribute("daftarPemesanan", adminVerifikasiService.getDaftarPemesananMenunggu());
        return "admin/verifikasi";
    }

    @PostMapping("/{id}/setujui")
    public String prosesVerifikasi(@PathVariable("id") UUID idPemesanan, RedirectAttributes redirectAttributes) {
        try {
            adminVerifikasiService.verifikasiPemesanan(idPemesanan);
            redirectAttributes.addFlashAttribute("sukses",
                    "Pemesanan berhasil diverifikasi (Lunas), kamar diperbarui menjadi Terisi, dan log tercatat.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Gagal memverifikasi pemesanan: " + e.getMessage());
        }
        return "redirect:/admin/verifikasi";
    }
}