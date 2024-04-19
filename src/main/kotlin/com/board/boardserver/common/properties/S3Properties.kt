package com.board.boardserver.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@ConfigurationProperties(prefix = "aws.s3")
class S3Properties(
    val accessKey: String,
    val secretKey: String,
    val bucketName: String,
    val folderPath: String
)