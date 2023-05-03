package com.bukrain.shareasy.query.entity.blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "blob_metadata")
@NoArgsConstructor
@Getter
@Setter
public class BlobMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int size;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlobMetadata metadata = (BlobMetadata) o;
        return size == metadata.size && id.equals(metadata.id) && name.equals(metadata.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, name);
    }

    @Override
    public String toString() {
        return "BlobMetadata{" +
                "id='" + id + '\'' +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
