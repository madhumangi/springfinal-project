package com.hotelapp.respository;

import com.hotelapp.model.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacilityRepository extends JpaRepository<Facilities,Integer> {

    @Query("from Facilities f inner join f.hotels h where h.hotelId=?1")
    List<Facilities> findByHotelId(int hotelId);
}
