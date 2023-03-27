package org.example.service;

import org.example.command.Command;

public interface CommandService {
    Command retrieveCommand(String commandIdentifier);
}