package com.example.demo.TomaMiManoWeb.repositorios;

import com.example.demo.TomaMiManoWeb.entidades.Domicilio;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public  interface DomicilioRepositorio extends JpaRepository<Domicilio,String> {



}
