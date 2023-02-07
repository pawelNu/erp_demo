package com.erp_demo.controller;

import com.erp_demo.dto.InvoiceDTO;
import com.erp_demo.entity.InvoiceEntity;
import com.erp_demo.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    public InvoiceRepository invoiceRepository;

    // constructor
    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // display all invoices
    @GetMapping("")
    public List<InvoiceEntity> getAllInvoice() {
        return invoiceRepository.findAll();
    }


    // display invoice chosen by id
    @GetMapping("/{id}")
    public Optional<InvoiceEntity> getInvoice(@PathVariable("id") UUID id) {
        return invoiceRepository.findById(id);
    }

    // template to add invoice
    InvoiceDTO newInvoice = new InvoiceDTO();

    // generate invoice (add)
    @PostMapping("")
    public InvoiceEntity addInvoice(@RequestBody InvoiceDTO newInvoice) {
        InvoiceEntity invoice = new InvoiceEntity();

        invoice.setInvoiceNumber(newInvoice.getInvoiceNumber());
        invoice.setOperationDate(newInvoice.getOperationDate());
        invoice.setIssueDate(newInvoice.getIssueDate());
        invoice.setAccountingDate(newInvoice.getAccountingDate());
        invoice.setCounterpartyId(newInvoice.getCounterpartyId());
        invoice.setItemsId(newInvoice.getItemsId());

        invoiceRepository.save(invoice);
        return invoice;
    }

    // delete the invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable("id") UUID id) {
        invoiceRepository.deleteById(id);
    }


}
