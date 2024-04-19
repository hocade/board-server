package com.board.boardserver.attachment.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@Entity
@Table(name = "ATTACHMENT")
class AttachmentJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "EXT")
    var ext: String,

    @Column(name = "UPLOAD_FILE_NAME")
    var uploadFileName: String,

    @Column(name = "ORIGINAL_FILE_NAME")
    var originalFileName: String,

    @Column(name = "RESOURCE_URL")
    var resourceUrl: String,

    @Column(name = "FULL_PATH")
    var fullPath: String

) : BaseJpaEntity() {
}