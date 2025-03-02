//package com.agiles.UniChain.generic.controller;//package com.example.ChakriHub.generic.controller;
//
//import com.agiles.UniChain.generic.model.BaseEntity;
//import com.agiles.UniChain.generic.payload.request.IDto;
//import com.agiles.UniChain.generic.payload.request.SDto;
//import com.agiles.UniChain.generic.payload.response.BaseResponseDto;
//import com.agiles.UniChain.generic.service.IService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public abstract class AbstractController<E extends BaseEntity, D extends IDto, S extends SDto> implements IController<D> {
//
//    protected final IService<E, D, S> service;
//
//
//    private String getModelName(E entity) {
//        return entity.getClass().getSimpleName();
//    }
//
//
//    @Override
//    @GetMapping()
//    public <T extends BaseResponseDto> T getSingle(@PathVariable Long id) {
//        return service.getSingle(id);
//    }
//
//
//    @Override
//    @GetMapping
//    public ResponseEntity<List<Object>> getAll() {
//        return service.getAll();
//    }
//
//    @Override
//    @PostMapping()
//    public ResponseEntity<String> create(@Valid @RequestBody D dto) {
//        E entity = service.create(dto);
//        return ResponseEntity.ok("Created Successfully");
//    }
//
//    @Override
//    @PutMapping()
//    public ResponseEntity<String> update(@Valid @RequestBody D dto, @PathVariable Long id) {
//        E entity = service.update(dto, id);
//        return ResponseEntity.ok("Updated Successfully");
//    }
//
//    @Override
//    @PatchMapping(Router.PATH_VARIABLE_BY_ID)
//    public ResponseEntity<String> updateActiveStatus(@PathVariable Long id, @RequestParam(name = "isActive") Boolean isActive) {
//        service.updateActiveStatus(id, isActive);
//        MessageResponse message = new MessageResponse(Message.ACTIVE_STATUS_CHANGED_SUCCESSFULLY);
//        if (isActive) {
//            message = new MessageResponse(Message.ACTIVE_STATUS_TRUE_CHANGED_SUCCESSFULLY);
//        }
//        return ResponseEntity.ok(message);
//    }
//
//    @PostMapping(Router.SEARCH)
//    @PageableQueryParameters
//    public ResponseEntity<PageData> search(@RequestBody S searchDto) {
//        return new ResponseEntity<>(service.search(searchDto, searchDto.getPageable()), HttpStatus.OK);
//    }
//
//    @Override
//    @PostMapping(value = )
//    public ResponseEntity<MessageResponse> batchActiveStatus(@RequestBody GenericIdsDto ids) {
//        service.batchActiveStatus(ids);
//        return ResponseEntity.ok(new MessageResponse(Message.ACTIVE_STATUS_CHANGED_SUCCESSFULLY));
//    }
//}