//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.references;

import com.example.invoice.models.Reference;
import java.util.List;
import java.util.Optional;

public interface IreferencesDoa {
    List<Reference> allReferences();

    void addReference(Reference reference);

    Optional<Reference> getReference(long id);

    void deleteReference(long id);

    void updateReference(Reference reference);

    boolean isValidRefId(long id);


}
