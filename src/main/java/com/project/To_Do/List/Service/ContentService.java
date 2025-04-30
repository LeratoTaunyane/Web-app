package com.project.To_Do.List.Service;

import com.project.To_Do.List.DTO.ContentDTO;
import com.project.To_Do.List.Models.Content;
import com.project.To_Do.List.Repository.ContentRepostory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    private final ContentRepostory contentRepostory;

    public ContentService(ContentRepostory contentRepostory) {
        this.contentRepostory = contentRepostory;
    }

    public ContentDTO createContent(ContentDTO contentDTO){
        Content content = new Content();
        content.setDescription(contentDTO.getDescription());

        Content saveContent = contentRepostory.save(content);
        return mapToDTO(saveContent);
    }

    public List<ContentDTO> getAllContent(){
        List<Content> content = contentRepostory.findAll();
        return content.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ContentDTO getContentById(Integer id){
        Content content = contentRepostory.findById(id).orElseThrow(RuntimeException::new);
        return mapToDTO(content);
    }

    public ContentDTO updateContent(Integer id, ContentDTO contentDTO){
        Content content = contentRepostory.findById(id).orElseThrow(RuntimeException:: new);
        content.setDescription(contentDTO.getDescription());

        Content saveUpdatedContent = contentRepostory.save(content);
        return mapToDTO(saveUpdatedContent);
    }

    private ContentDTO mapToDTO(Content content){
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setId(content.getId());
        contentDTO.setDescription(content.getDescription());
        return contentDTO;
    }

}
