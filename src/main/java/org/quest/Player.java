package org.quest;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {

    private String name;
    private String playerClass;
    private int health = 100;
    private List<Item> inventory;


}
