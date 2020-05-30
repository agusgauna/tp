package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.CourseParticipantDto;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.CourseParticipant;
import ar.com.ada.tp.model.entity.CourseParticipantId;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.mapper.CourseParticipantMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.CourseParticipantRepository;
import ar.com.ada.tp.model.repository.CourseRepository;
import ar.com.ada.tp.model.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseParticipantServices")
public class CourseParticipantServices {

    @Autowired @Qualifier("courseParticipantRepository")
    private CourseParticipantRepository courseParticipantRepository;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private final CourseParticipantMapper courseParticipantMapper = CourseParticipantMapper.MAPPER;

    public List<CourseParticipantDto> findAll() {
        List<CourseParticipant> all = courseParticipantRepository.findAll();
        List<CourseParticipantDto> courseParticipantDtoList = courseParticipantMapper.toDto(all, context);

        return courseParticipantDtoList;
    }

    public CourseParticipantDto saveCourseParticipant (CourseParticipantDto dto, Long courseId, Long participantId) {
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Course", courseId));

        Participant participant = participantRepository
                .findById(participantId)
                .orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Participant", participantId));

        CourseParticipantId courseParticipantId = new CourseParticipantId()
                .setCourseId(course.getId())
                .setParticipantId(participant.getId());

        CourseParticipant courseParticipantToSave = courseParticipantMapper.toEntity(dto, context);
        courseParticipantToSave.setId(courseParticipantId);
        courseParticipantToSave.setCourse(course);
        courseParticipantToSave.setParticipant(participant);
        CourseParticipant courseParticipantSaved = courseParticipantRepository.save(courseParticipantToSave);
        CourseParticipantDto courseParticipantDtoSaved = courseParticipantMapper.toDto(courseParticipantSaved, context);

        return courseParticipantDtoSaved;
    }

}
