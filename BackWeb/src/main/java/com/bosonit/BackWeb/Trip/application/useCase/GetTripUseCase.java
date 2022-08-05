package com.bosonit.BackWeb.Trip.application.useCase;


import com.bosonit.BackWeb.Client.infraestructure.DTOs.OutputClientDTO;
import com.bosonit.BackWeb.Exceptions.NotFoundException;
import com.bosonit.BackWeb.Trip.application.port.GetTripPort;
import com.bosonit.BackWeb.Trip.domain.Trip;
import com.bosonit.BackWeb.Trip.infraestructure.DTOs.OutputTripDTO;
import com.bosonit.BackWeb.Trip.infraestructure.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class GetTripUseCase implements GetTripPort {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    ModelMapper modelMapper;

    public OutputTripDTO getTripById(Integer id) throws Exception{
        Trip trip = tripRepository.findById(id).orElseThrow(()-> new NotFoundException("Ruta de viaje no encontrada"));
        OutputTripDTO outputTripDTO = modelMapper.map(trip, OutputTripDTO.class);
        return outputTripDTO;
    }

    public List<OutputTripDTO> getAllTrips() {
        List<Trip> trips = tripRepository.findAll();
        TypeToken<List<OutputTripDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputTripDTO> outputTripDTO = modelMapper.map(trips , typeToken.getType());
        return outputTripDTO;
    }

    //////////////////////////CRITERIA BUILDER////////////////

    @PersistenceContext
    private EntityManager entityManager;

    public List<Trip> getData(HashMap<String, String> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        //funcionando el orderby

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field){
                case "origen":
                    predicates.add(cb.equal(root.get(field),(String) value));
                    break;
                case "destino":
                    predicates.add(cb.equal(root.get(field),(String) value));
                    break;
                    //El de fecha funciona
                case "fecha":
                    String dateCondition=(String) conditions.get("dateCondition");
                    LocalDate fecha = parseDate(value);
                    switch (dateCondition)
                    {
                        case "after":
                            predicates.add(cb.greaterThan(root.<LocalDate>get(field),fecha));
                            break;
                        case "before":
                            predicates.add(cb.lessThan(root.<LocalDate>get(field),fecha));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.<Date>get(field),fecha));
                            break;
                    }
                    break;
                case "hora":
                    String hourCondition=(String) conditions.get("hourCondition");
                    LocalTime hour = parseHour(value);
                    switch (hourCondition)
                    {
                        case "after":
                            predicates.add(cb.greaterThan(root.<LocalTime>get(field),hour));
                            break;
                        case "before":
                            predicates.add(cb.lessThan(root.<LocalTime>get(field),hour));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.<Date>get(field),hour));
                            break;
                    }
                    break;
            }

        });

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }

    //////////////////////////CRITERIA BUILDER////////////////
    private LocalDate parseDate(String value) {
        LocalDate creationDate;
        creationDate = LocalDate.parse(value);
        return creationDate;
    }

    private LocalTime parseHour(String value) {
        LocalTime creationHour;
        creationHour = LocalTime.parse(value);
        return creationHour;
    }


}
