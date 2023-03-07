package org.example.handler.serviceCommandHandler;

import java.util.HashSet;
import java.util.Set;

import static org.example.bot.settings.CommandConst.*;

public class CommandServiceType {

    public Set<String> types () {

        Set<String> types = new HashSet<String>();
        types.add(START);
        types.add(KEY);
        types.add(INFO);

        return types;

    }

}
