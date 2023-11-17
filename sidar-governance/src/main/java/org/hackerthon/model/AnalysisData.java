package org.hackerthon.model;

import org.hackerthon.database.ResponsesDO;

import java.util.Collection;

public class AnalysisData {

    public static Long getNon_existent(Collection<ResponsesDO> responses) {
        return responses.stream().map(ResponsesDO::getNon_existent)
                .count();
    }

    public static Long getSome_elements( Collection<ResponsesDO> responses) {
        return responses.stream().map(ResponsesDO::getSome_elements)
                .count();
    }

    public static Long getMinimal(Collection<ResponsesDO> responses) {
        return responses.stream().map(ResponsesDO::getMinimal).count();
    }

    public static Long getLargely_in_place(Collection<ResponsesDO> responses) {
        return responses.stream().map(ResponsesDO::getLargely_in_place).count();
    }

    public static Long getFully_in_place(Collection<ResponsesDO> responses) {
        return responses.stream().map(ResponsesDO::getFully_in_place).count();
    }
}
