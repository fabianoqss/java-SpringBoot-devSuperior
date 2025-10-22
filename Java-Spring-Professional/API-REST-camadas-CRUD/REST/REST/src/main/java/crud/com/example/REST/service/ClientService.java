package crud.com.example.REST.service;

import crud.com.example.REST.dto.ClientDTO;
import crud.com.example.REST.entities.Client;
import crud.com.example.REST.repository.ClientRepository;
import crud.com.example.REST.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findByID(Long id){
        Client client = clientRepository.findById(id).orElseThrow
                (()-> new ResourceNotFoundException("Cliente " + id + " não encontrado no Banco de Dados."));
        return new ClientDTO(client);
    }


    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientRepository.findAll(pageable).map(ClientDTO::new);
    }


    @Transactional
    public ClientDTO insert(ClientDTO clientDTO){
        Client client = new Client();
        copyDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id , ClientDTO dto){
        Client client = clientRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Cliente "+ id + " não encontrado."));
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Cliente " + id + " não encontrado. ");
        }
            clientRepository.deleteById(id);
    }


    private void copyDtoToEntity(ClientDTO dto, Client client){
        client.setName(dto.getName());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
    }


}
