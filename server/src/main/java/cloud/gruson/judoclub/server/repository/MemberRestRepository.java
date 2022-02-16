package cloud.gruson.judoclub.server.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cloud.gruson.judoclub.server.entity.MemberEntity;

@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRestRepository extends PagingAndSortingRepository<MemberEntity, UUID> {
    
    List<MemberEntity> findIgnoreCaseByLastName(String lastName);

}
