package com.app.handcraft.entity.inventory;
import com.app.handcraft.entity.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_PRODUCT_SPECIFICATION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductSpecification extends AuditLog {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADPRSP_ID", insertable = false, updatable = false, nullable = false)
    private Long adprspId;
    @Column(name="CATEGORY", unique = false, nullable = true)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name="TITLE", unique = false, nullable = true)
    @Enumerated(EnumType.STRING)
    private Title title;
    @Column(name="INFO", unique = false, nullable = true)
    @Lob
    private byte[] info;



    public enum Title {
        InTheBox("In The Box"),//iPhone, EarPods with Lightning Connector, Lightning to USB Cable, USB Power Adapter, Documentation
        ModelNumber("Model Number"),//MX9R2HN/A
        ModelName("Model Name"),//iPhone SE
        Color("Color"),//Black
        BrowseType("Browse Type"),//Smartphones
        SIMType("SIM Type"),//Dual Sim
        HybridSimSlot("Hybrid Sim Slot"),//No
        Touchscreen("Touchscreen"),//Yes
        OTGCompatible("OTG Compatible"),//No
        QuickCharging("Quick Charging"),//Yes
        SoundEnhancements("Sound Enhancements"),//Built-in Stereo Speaker
        DisplaySize("Display Size"),//11.94 cm (4.7 inch)
        Resolution("Resolution"),//1334 x 750 Pixels
        ResolutionType("Resolution Type"),//Retina HD Display
        DisplayType("Display Type"),//Retina HD Display
        OtherDisplayFeatures("Other Display Features"),//Widescreen HD LCD Retina Multi-touch IPS Display (1400:1 Contrast Ratio (Typical), True Tone Display, Wide Color Display (P3), Haptic Touch, 625 nits Max Brightness (Typical), Fingerprint-resistant Oleophobic Coating, Display Zoom, Reachability)
        OperatingSystem("Operating System"),//iOS 13
        ProcessorType("Processor Type"),//A13 Bionic Chip with 3rd Gen Neural Engine
        InternalStorage("Internal Storage"),//64 GB
        PrimaryCameraAvailable("Primary Camera Available"),//Yes
        PrimaryCamera("Primary Camera"),//12MP Rear Camera
        PrimaryCameraFeatures("Primary Camera Features"),//12MP Wide Camera, F/1.8 Aperture, Portrait Mode with Advanced Bokeh and Depth Control, Portrait Lighting with Six Effects (Natural, Studio, Contour, Stage, Stage Mono, High-Key Mono), Optical Image Stabilisation, Six‑element Lens, Panorama (Upto 63 MP), Sapphire Crystal Lens Cover, Autofocus with Focus Pixels, Wide Color Capture for Photos and Live Photos, Next-generation Smart HDR for Photos, Advanced Red-eye Correction, Auto Image Stabilisation, Burst Mode, Photo Geotagging, Image Formats Captured: HEIF and JPEG | Video: 4K Video Recording Upto 60 fps, 1080p HD Video Recording Upto 60fps, 720p HD Video Recording at 30 fps, Extended Dynamic Range for Video Upto 30 fps, Optical Image Stabilisation for Video, QuickTake Video, Slow-motion Video Support for 1080p Upto 240 fps, Time-lapse Video with Stabilisation, Cinematic Video Stabilisation (4K,1080p and 720p), Continuous Autofocus Video, Take 8 MP Still Photos while Recording 4K Video, Playback Zoom, Video Formats Recorded: HEVC and H.264, Stereo Recording
        SecondaryCameraAvailable("Secondary Camera Available"),//Yes
        SecondaryCamera("Secondary Camera"),//7MP Front Camera
        SecondaryCameraFeatures("Secondary Camera Features"),//7 MP Camera, F/2.2 Aperture, Portrait Mode with Advanced Bokeh and Depth Control, Portrait Lighting with Six Effects (Natural, Studio, Contour, Stage, Stage Mono, High-Key Mono), 1080p HD Video Recording at 30 fps, QuickTake Video, Wide Color Capture for Photos and Live Photos, Auto HDR for Photos, Auto Image Stabilisation, Burst Mode, Cinematic Video Stabilisation (1080p and 720p)
        Flash("Flash"),//Rear: LED True Tone Flash with Slow Sync | Front: Retina Flash
        HDRecording("HD Recording"),//Yes
        FullHDRecording("Full HD Recording"),//Yes
        VideoRecording("Video Recording"),//Yes
        VideoRecordingResolution("Video Recording Resolution"),//4K, 1080p, 720p
        DigitalZoom("Digital Zoom"),//Photo: Digital Zoom Upto 5x, Video: Digital Zoom Upto 3x
        CallWaitHold("Call Wait/Hold"),//Yes
        NetworkType("Network Type"),//4G VOLTE, 4G, 3G, 2G
        SupportedNetworks("Supported Networks"),//4G VoLTE, 4G LTE, WCDMA, GSM
        InternetConnectivity("Internet Connectivity"),//4G, 3G, Wi-Fi, EDGE
        PreInstalledBrowser("Pre-installed Browser"),//Safari
        BluetoothSupport("Bluetooth Support"),//Yes
        BluetoothVersion("Bluetooth Version"),//v5.0
        WiFi("Wi-Fi"),//Yes
        WiFiVersion("Wi-Fi Version"),//802.11ax (Wi-Fi 6 with 2x2 MIMO)
        WiFiHotspot("Wi-Fi Hotspot"),//Yes
        NFC("NFC"),//Yes
        EDGE("EDGE"),//Yes
        MapSupport("Map Support"),//Maps
        GPSSupport("GPS Support"),//Yes
        Smartphone("Smartphone"),//Yes
        SIMSize("SIM Size"),//Nano + eSIM
        MobileTracker("Mobile Tracker"),//Yes
        RemovableBattery("Removable Battery"),//No
        SMS("SMS"),//Yes
        GraphicsPPI("Graphics PPI"),//326 PPI
        Sensors("Sensors"),//Touch ID Fingerprint Sensor, Barometer, Three-axis gyro, Accelerometer, Proximity Sensor, Ambient Light Sensor
        Series("Series"),//iPhone SE
        OtherFeatures("Other Features"),//Splash, Water and Dust Resistant (IP67 Rated (Maximum Depth of 1 metre Upto 30 mins) Under IEC Standard 60529), Fingerprint Sensor Built into the Home Hutton, Digital Compass, iBeacon Micro-location, Video Calling (FaceTime Video Calling Over Wi-Fi or Mobile Data), Audio Calling (FaceTime Audio Calling Over Wi-Fi or Mobile Data, Voice over LTE (VoLTE), Wi-Fi Calling), Fast Charge Capable (Upto 50% Charge in 30 mins with 18 W Adapter or Higher), Wireless Charging (Works with Qi Chargers), Accessibility: Voice Control, VoiceOver, Zoom, Magnifier, RTT and TTY Support, Siri and Dictation, Type to Siri, Switch Control, Closed Captions, AssistiveTouch, Speak Screen, Rating for Hearing Aids: M3, T4
        GPSType("GPS Type"),//A-GPS, GLONASS
        AudioFormats("Audio Formats"),//AAC-LC, HE-AAC, HE-AAC v2, Protected AAC, MP3, Linear PCM, Apple Lossless, FLAC, Dolby Digital (AC-3), Dolby Digital Plus (E-AC-3) and Audible (Formats 2, 3, 4, Audible Enhanced Audio, AAX and AAX+)
        VideoFormats("Video Formats"),//HEVC, H.264, MPEG-4 Part 2 and Motion JPEG
        Width("Width"),//67.3 mm
        Height("Height"),//138.4 mm
        Depth("Depth"),//7.3 mm
        Weight("Weight"),//148 g
        WarrantySummary("Warranty Summary"),//Brand Warranty for 1 Year
        DomesticWarranty("Domestic Warranty");//1 Year

        private final String value;

        private Title(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Category {

        General("General"),
        DisplayFeatures("Display Features"),
        OsAndProcessorFeatures("Os & Processor Features"),
        MemoryAndStorageFeatures("Memory & Storage Features"),
        CameraFeatures("Camera Features"),
        CallFeatures("Call Features"),
        ConnectivityFeatures("Connectivity Features"),
        OtherDetails("Other Details"),
        MultimediaFeatures("Multimedia Features"),
        Dimensions("Dimensions"),
        Warranty("Warranty");

        private final String value;

        private Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
