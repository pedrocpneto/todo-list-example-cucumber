package net.pcpinfo.todolistexemplo.todo;

import lombok.Builder;
import lombok.Value;

public enum Todo {;
    public interface Id { Long getId(); }
    public interface Title { String getTitle(); }
    public interface Observation { String getObservation(); }


    public enum Request{;
        @Value @Builder(builderMethodName = "with")
        public static class Create implements Title, Observation {
            String title; String observation;
        }
    }

    public enum Response{;
        @Value
        public static class Default implements Id, Title, Observation {
            Long id; String title; String observation;
        }
    }
}
