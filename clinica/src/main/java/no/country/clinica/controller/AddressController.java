package no.country.clinica.controller;

import no.country.clinica.domain.service.IAddressService;
import no.country.clinica.domain.util.Url;
import no.country.clinica.dto.AddressDTO;
import no.country.clinica.dto.SpecialtyDTO;
import no.country.clinica.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.ADDRESSES_URI)
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@Valid @RequestBody AddressDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        AddressDTO savedAddress = addressService.addAddress(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@Valid @RequestBody AddressDTO dto,
                                                        @PathVariable Long id,
                                                        BindingResult result){
        if (result.hasErrors()) {throw new BadRequestException(result);}
        return new ResponseEntity<>(addressService.updateById(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(name = "id") Long id){
        addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddresses(){
        List<AddressDTO> result = this.addressService.getAll();
        return ResponseEntity.ok().body(result);
    }
}
