package com.agiles.UniChain.generic.model;
import com.agiles.UniChain.auth.model.User;
import com.agiles.UniChain.generic.utils.Helper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User createdBy;
    @Column(name = "created_by_id", insertable = false, updatable = false)
    private Long createdById;

    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User updatedBy;
    @Column(name = "updated_by_id", insertable = false, updatable = false)
    private Long updatedById;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = true;

    @PrePersist
    private void onBasePersist() {
        User user = Helper.getCurrentUser();
        if (user != null && this.createdBy == null) {
            this.createdBy = user;
        }
        this.isActive = true;
    }


    @PreUpdate
    private void onBaseUpdate() {
        User user = Helper.getCurrentUser();
        if (user != null) {
            this.updatedBy = user;
        } else {
            this.updatedBy = this.createdBy;
        }
        this.updatedTime = LocalDateTime.now();
    }

    //This part is for Audit Log
//    public ConcurrentHashMap< String, Object > getEntityMap( String operationType, String userName ) {
//        ConcurrentHashMap< String, Object > resultMap = new ConcurrentHashMap<>();
//        resultMap.put( ApplicationConstant.IS_ACTIVE_FIELD, this.getIsActive() );
//        resultMap.put( ApplicationConstant.CREATED_AT_FIELD, Objects.nonNull( this.getCreatedTime() ) ?
//                this.getCreatedTime() : LocalDateTime.now() );
//        resultMap.put( ApplicationConstant.CREATED_BY_FIELD, Objects.nonNull( this.getCreatedBy() )
//                ? this.getCreatedBy().getUsername() : "Anonymous" );
//        // resultMap.put(ApplicationConstant.ID, this.getId());
//
//        if ( Objects.isNull( this.getUpdatedTime() ) && AuditOperation.UPDATE.name().equalsIgnoreCase( operationType ) ) {
//            resultMap.put( ApplicationConstant.MODIFIED_AT_FIELD, LocalDateTime.now() );
//            resultMap.put( ApplicationConstant.MODIFIED_BY_FIELD, userName );
//        } else if ( Objects.nonNull( this.getUpdatedTime() ) && AuditOperation.UPDATE.name().equalsIgnoreCase( operationType ) ) {
//            resultMap.put( ApplicationConstant.MODIFIED_AT_FIELD, this.getUpdatedTime() );
//            resultMap.put( ApplicationConstant.MODIFIED_BY_FIELD, Objects.nonNull( this.getUpdatedBy() )
//                    ? this.getUpdatedBy().getUsername() : "Anonymous" );
//        }

//        return resultMap;
//    }
}