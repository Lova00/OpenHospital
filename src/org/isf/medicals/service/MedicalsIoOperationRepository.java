package org.isf.medicals.service;

import java.util.List;

import org.isf.medicals.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MedicalsIoOperationRepository extends JpaRepository<Medical, Integer> {
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A order BY MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllByOrderByDescription();    
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where MDSRT_DESC like :description order BY MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereDescriptionOrderByDescription(@Param("description") String description );    
    
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSR_DESC like %:description% OR MDSR_CODE like %:description%) and (MDSRT_ID_A=:type) and ((MDSR_INI_STOCK_QTI+MDSR_IN_QTI-MDSR_OUT_QTI)<MDSR_MIN_STOCK_QTI) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereDescriptionAndTypeAndCriticalOrderByTypeAndDescritpion(@Param("description") String description, @Param("type") String type);  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSR_DESC like %:description% OR MDSR_CODE like %:description%) and (MDSRT_ID_A=:type) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)   
    public List<Medical> findAllWhereDescriptionAndTypeOrderByTypeAndDescritpion(@Param("description")String description, @Param("type") String type);  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSR_DESC like %:description% OR MDSR_CODE like %:description%) and ((MDSR_INI_STOCK_QTI+MDSR_IN_QTI-MDSR_OUT_QTI)<MDSR_MIN_STOCK_QTI) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereDescriptionAndCriticalOrderByTypeAndDescritpion(@Param("description")String description);  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSR_DESC like %:description% OR MDSR_CODE like %:description%) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereDescriptionOrderByTypeAndDescritpion(@Param("description")String description);      
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSRT_ID_A=:type) and ((MDSR_INI_STOCK_QTI+MDSR_IN_QTI-MDSR_OUT_QTI)<MDSR_MIN_STOCK_QTI) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereTypeAndCriticalOrderByTypeAndDescritpion(@Param("type") String type);  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where (MDSRT_ID_A=:type) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)   
    public List<Medical> findAllWhereTypeOrderByTypeAndDescritpion(@Param("type") String type);  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A where ((MDSR_INI_STOCK_QTI+MDSR_IN_QTI-MDSR_OUT_QTI)<MDSR_MIN_STOCK_QTI) order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllWhereCriticalOrderByTypeAndDescritpion();  
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A order BY MDSR_MDSRT_ID_A, MDSR_DESC", nativeQuery= true)
    public List<Medical> findAllByOrderByTypeAndDescritpion();  
    
    @Query(value = "SELECT * FROM MEDICALDSR WHERE MDSR_MDSRT_ID_A = :type AND MDSR_DESC = :description", nativeQuery= true)
    public Medical findOneWhereDescriptionAndType(@Param("description") String description, @Param("type") String type);   
    @Query(value = "SELECT * FROM MEDICALDSR WHERE MDSR_MDSRT_ID_A = :type AND MDSR_DESC = :description AND MDSR_ID <> :id", nativeQuery= true)
    public Medical findOneWhereDescriptionAndType(@Param("description") String description, @Param("type") String type, @Param("id") Integer id);
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A WHERE MDSR_DESC SOUNDS LIKE :description", nativeQuery = true)
    public List<Medical> findAllWhereDescriptionSoundsLike(@Param("description") String description);
    @Query(value = "SELECT * FROM MEDICALDSR JOIN MEDICALDSRTYPE ON MDSR_MDSRT_ID_A = MDSRT_ID_A WHERE MDSR_DESC SOUNDS LIKE :description AND MDSR_ID <> :id", nativeQuery = true)
    public List<Medical> findAllWhereDescriptionSoundsLike(@Param("description") String description, @Param("id") Integer id);
    @Query(value = "SELECT * FROM MEDICALDSR WHERE MDSR_CODE = :prod_code", nativeQuery = true)
    public Medical findOneWhereProductCode(@Param("prod_code") String prod_code);
    @Query(value = "SELECT * FROM MEDICALDSR WHERE MDSR_CODE = :prod_code AND MDSR_ID <> :id", nativeQuery = true)
    public Medical findOneWhereProductCode(@Param("prod_code") String prod_code, @Param("id") Integer id);
    
}
