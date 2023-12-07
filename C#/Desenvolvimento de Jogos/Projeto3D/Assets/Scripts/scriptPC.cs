using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptPC : MonoBehaviour
{
    private Rigidbody rbd;
    public float velocidade = 5;
    public float velRot = 200;
    private Quaternion rotOriginal;
    private Vector3 posInicial;
    private float rotMouseX = 0;
    public LayerMask alvo;
    private AudioSource som;
    public AudioClip somTiro;
    public AudioClip somVazio;
    public bool mortal = true;

    private void OnCollisionEnter(Collision col){
        if(col.gameObject.tag == "NPC"){
            death();
        }
    }
    void Start()
    {
        rbd = GetComponent<Rigidbody>();
        som = GetComponent<AudioSource>();
        rotOriginal = transform.localRotation;
        posInicial = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        mover();
        atirar();
        
    }

    void mover(){
        float moveFrente = Input.GetAxis("Vertical");
        float moveLado = Input.GetAxis("Horizontal");

        Vector3 vel = transform.TransformDirection(new Vector3(moveLado * velocidade, rbd.velocity.y, moveFrente *velocidade));
        
        rotMouseX += Input.GetAxis("Mouse X");
        Quaternion lado = Quaternion.AngleAxis(rotMouseX,Vector3.up);
        transform.localRotation = rotOriginal * lado;
        
        
        rbd.velocity = vel;

        int rot = 0;

        transform.Rotate(new Vector3(0,rot*Time.deltaTime * velRot,0));
    }


    void atirar(){
        if(Input.GetMouseButtonDown(0)){
            if(scriptUI.municao > 0){
                 RaycastHit hit;
                if(Physics.Raycast(transform.position,transform.forward, out hit, 100, alvo)){
                    Destroy(hit.collider.gameObject);
                    scriptRespawn.npcCont--;
                }
                som.PlayOneShot(somTiro, 0.7f);
                scriptUI.municao--;

            }else{
                Debug.Log("Sem Municao");
                som.PlayOneShot(somVazio, 0.7f);
            }
        }
    }

    void death(){
        if(mortal){
            transform.position = posInicial;
            scriptUI.vida--;
        }
    }
        
}
