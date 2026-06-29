package be.bstorm.tf_java_2026_rcd_bend.models.shared;

import java.util.List;

public record CustomPage<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int pageSize
) {
}
