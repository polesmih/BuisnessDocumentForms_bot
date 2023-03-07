package org.example.handler.typesOfDocumentsHandler;

import java.util.HashSet;
import java.util.Set;

import static org.example.handler.typesOfDocumentsHandler.DocumentTypesConst.*;

public class DocumentTypes {

    public Set<String> types () {

        Set<String> types = new HashSet<String>();
        types.add(ACTS);
        types.add(CLAIMS);
        types.add(CONTRACTS);
        types.add(CUSTOMER);
        types.add(PROXY);
        types.add(VOUCHERS);

        return types;

    }


}
