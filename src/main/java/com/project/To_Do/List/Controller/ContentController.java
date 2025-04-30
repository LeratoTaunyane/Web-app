package com.project.To_Do.List.Controller;

import com.project.To_Do.List.DTO.ContentDTO;
import com.project.To_Do.List.Service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContent() {
        List<ContentDTO> content = contentService.getAllContent();
        return ResponseEntity.ok(content);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContentById(@PathVariable Integer id) {
        try {
            ContentDTO content = contentService.getContentById(id);
            return ResponseEntity.ok(content);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO content = contentService.createContent(contentDTO);
        return ResponseEntity.ok(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContent(@PathVariable Integer id, @RequestBody ContentDTO contentDTO) {
        try {
            ContentDTO updatedContent = contentService.updateContent(id, contentDTO);
            return ResponseEntity.ok(updatedContent);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
