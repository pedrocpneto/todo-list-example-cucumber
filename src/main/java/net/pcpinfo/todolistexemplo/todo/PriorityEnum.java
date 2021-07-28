package net.pcpinfo.todolistexemplo.todo;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum PriorityEnum {
    LOW("BAIXA", 100),
    MEDIUM("MEDIA", 200),
    HIGH("ALTA", 300);

    public final String name;
    public final int value;

    public static PriorityEnum fromName(String priorityName) {
        return Arrays.stream(PriorityEnum.values()).filter(priorityEnum -> priorityEnum.name.equalsIgnoreCase(priorityName)).findFirst().orElse(null);
    }

    public static PriorityEnum fromValue(int value) {
        return Arrays.stream(PriorityEnum.values()).filter(priorityEnum -> priorityEnum.value == value).findFirst().orElse(null);
    }
}
