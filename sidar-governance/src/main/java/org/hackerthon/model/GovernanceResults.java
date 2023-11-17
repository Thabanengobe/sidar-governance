package org.hackerthon.model;

import org.hackerthon.database.SidarResponsesDO;

import java.util.Collection;

public class GovernanceResults {

    public Long getNon_existent(Collection<SidarResponsesDO> responsesDOS) {
        return responsesDOS.stream().map(SidarResponsesDO::getNon_existent)
                .count();
    }

    public Long getSome_elements( Collection<SidarResponsesDO> responsesDOS) {
        return responsesDOS.stream().map(SidarResponsesDO::getSome_elements)
                .count();
    }

    public Long getMinimal(Collection<SidarResponsesDO> responsesDOS) {
        return responsesDOS.stream().map(SidarResponsesDO::getMinimal).count();
    }

    public Long getLargely_in_place(Collection<SidarResponsesDO> responsesDOS) {
        return responsesDOS.stream().map(SidarResponsesDO::getLargely_in_place).count();
    }

    public Long getFully_in_place(Collection<SidarResponsesDO> responsesDOS) {
        return responsesDOS.stream().map(SidarResponsesDO::getFully_in_place).count();
    }
}
