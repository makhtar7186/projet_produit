package sn.esmt.boutique.web;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.processing.Find;
import org.springframework.web.bind.annotation.*;
import sn.esmt.boutique.entity.ProduitEntity;
import sn.esmt.boutique.service.ProduitService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produits")
@AllArgsConstructor
public class ProduitController {
  private ProduitService produitService;
  @PostMapping
  public ProduitEntity save(ProduitEntity produitEntity){
    return produitService.save(produitEntity);
  }

  @GetMapping
  public List<ProduitEntity> all(){
    return produitService.getAll().get();
  }
  @GetMapping("/{ref}")
  public Optional<ProduitEntity> find(String ref) {
    return produitService.get(ref);
  }
  @DeleteMapping
  public void delete(String ref){
    produitService.delete(ref);
  }
  @PutMapping
  public ProduitEntity update(String ref,ProduitEntity produitEntity){
    return produitService.update(ref,produitEntity);
  }



}
